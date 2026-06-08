package com.sobia.library_management.service;

import com.sobia.library_management.entity.Member;
import com.sobia.library_management.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Step 1 — User requests reset
    public void requestPasswordReset(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No account found with email: " + email));

        // Generate unique token
        String token = UUID.randomUUID().toString();

        // Set token and expiry (1 hour from now)
        member.setResetToken(token);
        member.setResetTokenExpiry(LocalDateTime.now().plusHours(1));
        memberRepository.save(member);

        // Send email
        emailService.sendPasswordResetEmail(email, token);
    }

    // Step 2 — User resets password with token
    public void resetPassword(String token, String newPassword) {
        Member member = memberRepository.findByResetToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid or expired reset token"));

        // Check if token is expired
        if (member.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Reset token has expired. Please request a new one.");
        }

        // Set new password
        member.setPassword(passwordEncoder.encode(newPassword));

        // Clear the token
        member.setResetToken(null);
        member.setResetTokenExpiry(null);
        memberRepository.save(member);
    }
}