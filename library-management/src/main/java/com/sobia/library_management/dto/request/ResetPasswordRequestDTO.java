package com.sobia.library_management.dto.request;

import lombok.Data;

@Data
public class ResetPasswordRequestDTO {
    private String token;
    private String newPassword;
}