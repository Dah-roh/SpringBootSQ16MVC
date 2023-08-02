package com.sq16.facebookclone.Controllers;

import com.sq16.facebookclone.DTOs.LoginDTO;
import com.sq16.facebookclone.DTOs.PostDTO;
import com.sq16.facebookclone.DTOs.SignUpDTO;
import com.sq16.facebookclone.Models.Users;
import com.sq16.facebookclone.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
@Slf4j
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //        @RequestMapping("")
        @GetMapping("")
    public ModelAndView loginPage() {
            return new ModelAndView("index")
                    .addObject("login", new LoginDTO());
        }

//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    same as below. Newer version


    @GetMapping("/sign-up")
    public ModelAndView signUp(){
            return  new ModelAndView("signup").addObject("signUpForm", new SignUpDTO());
    }

    @PostMapping("/sign-up")
    public ModelAndView signUp(SignUpDTO signUpDTO){
        Users user = userService.saveUser(signUpDTO);
         if(user!=null){
             return new ModelAndView("index")
                     .addObject("login", new LoginDTO())
                     .addObject("userMessage", "Sign up successful, please login.");
         }
         return new ModelAndView("signup")
                 .addObject("signUpForm",  new SignUpDTO());
    }



    @PostMapping("/login")

    public ModelAndView login(LoginDTO loginDTO ){
    //loginDTO is creating our method object dependencies dependency injection through inversion of control
        log.info("USER - EMAIL-----> {"+loginDTO.getEmail()+"} ");
        Users user = userService.findByEmail(loginDTO.getEmail());
        PostDTO postDTO = new PostDTO();
        postDTO.setUser(user);
        if (user == null) {
            return new ModelAndView("index");
        }
        return new ModelAndView("profile")
                .addObject("dashboardMessage",
                        "Welcome, user with email: "+loginDTO.getEmail())
                .addObject("post", postDTO);
    }

}
