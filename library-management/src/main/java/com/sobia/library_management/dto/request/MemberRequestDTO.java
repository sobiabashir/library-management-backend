package com.sobia.library_management.dto.request;

import com.sobia.library_management.enums.Role;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate membershipDate;
    private Role role;
    private String password;
}