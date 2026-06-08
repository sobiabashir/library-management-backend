package com.sobia.library_management.service;

import com.sobia.library_management.dto.request.MemberRequestDTO;
import com.sobia.library_management.dto.response.MemberResponseDTO;
import com.sobia.library_management.entity.Member;
import com.sobia.library_management.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberResponseDTO> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MemberResponseDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        return convertToDTO(member);
    }
    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MemberResponseDTO createMember(MemberRequestDTO requestDTO) {
        Member member = new Member();
        member.setFirstName(requestDTO.getFirstName());
        member.setLastName(requestDTO.getLastName());
        member.setEmail(requestDTO.getEmail());
        member.setPhone(requestDTO.getPhone());
        member.setMembershipDate(requestDTO.getMembershipDate());
        member.setRole(requestDTO.getRole());
        member.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        Member saved = memberRepository.save(member);

        // Send welcome email
        emailService.sendWelcomeEmail(
                saved.getEmail(),
                saved.getFirstName(),
                requestDTO.getPassword()
        );

        return convertToDTO(saved);
    }

    public MemberResponseDTO updateMember(Long id, MemberRequestDTO requestDTO) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        member.setFirstName(requestDTO.getFirstName());
        member.setLastName(requestDTO.getLastName());
        member.setEmail(requestDTO.getEmail());
        member.setPhone(requestDTO.getPhone());
        member.setMembershipDate(requestDTO.getMembershipDate());
        member.setRole(requestDTO.getRole());
        Member updated = memberRepository.save(member);
        return convertToDTO(updated);
    }

    public void deleteMember(Long id) {
        memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        memberRepository.deleteById(id);
    }

    private MemberResponseDTO convertToDTO(Member member) {
        MemberResponseDTO dto = new MemberResponseDTO();
        dto.setId(member.getId());
        dto.setFirstName(member.getFirstName());
        dto.setLastName(member.getLastName());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setMembershipDate(member.getMembershipDate());
        dto.setRole(member.getRole());
        return dto;
    }
}