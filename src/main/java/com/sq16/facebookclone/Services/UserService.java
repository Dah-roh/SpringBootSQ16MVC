package com.sq16.facebookclone.Services;

import com.sq16.facebookclone.DTOs.SignUpDTO;
import com.sq16.facebookclone.Models.Users;

public interface UserService {
    Users saveUser(SignUpDTO signUpDTO);

    Users findById(Long id);

    Users findByEmail(String email);
}
