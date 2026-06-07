package com.sobia.library_management.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String token;
    private String role;
    private String email;
    private String firstName;
}