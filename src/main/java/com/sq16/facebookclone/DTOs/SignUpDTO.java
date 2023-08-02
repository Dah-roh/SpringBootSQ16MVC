package com.sq16.facebookclone.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDTO {

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

}
