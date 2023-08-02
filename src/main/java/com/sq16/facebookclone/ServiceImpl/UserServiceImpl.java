package com.sq16.facebookclone.ServiceImpl;

import com.sq16.facebookclone.DTOs.SignUpDTO;
import com.sq16.facebookclone.Models.Users;
import com.sq16.facebookclone.Repositories.UserRepository;
import com.sq16.facebookclone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Users saveUser(SignUpDTO signUpDTO) {

        signUpDTO.setPassword(BCrypt.hashpw(signUpDTO.getPassword(), BCrypt.gensalt()));
        Users user = new Users(signUpDTO);
        return userRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NullPointerException("User Not found with ID: "+id));
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
