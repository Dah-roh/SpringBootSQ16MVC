package com.sq16.facebookclone.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/users")
@Slf4j
public class UserController {





    @GetMapping("/user/{dto}")
    public ModelAndView getUserProfile(@RequestParam("dto") String email){
        log.info("Inside userController class: ---> { "+email+"}");

        return new ModelAndView("profile");
    }
}
