package com.sq16.facebookclone.Controllers;

import com.sq16.facebookclone.DTOs.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/users")
@Slf4j
public class UserController {





    @GetMapping("/user")
    public ModelAndView getUserProfile(){
        log.info("UserController Class --> USER-ID : ");
        return new ModelAndView("profile").addObject("post", new PostDTO());
    }
}
