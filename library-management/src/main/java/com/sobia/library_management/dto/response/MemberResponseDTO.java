package com.sobia.library_management.dto.response;
import com.sobia.library_management.enums.Role;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate membershipDate;
    private Role role;
}
