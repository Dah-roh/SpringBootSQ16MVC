package com.sq16.facebookclone.Models;

import com.sq16.facebookclone.DTOs.SignUpDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public Users(SignUpDTO signUpDTO){
        this.firstName=signUpDTO.getFirstName();
        this.email=signUpDTO.getEmail();
        this.lastName=signUpDTO.getLastName();
        this.middleName=signUpDTO.getMiddleName();
        this.password=signUpDTO.getPassword();
    }
}
