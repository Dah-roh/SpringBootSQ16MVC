package com.sq16.facebookclone.Controllers;

import com.sq16.facebookclone.DTOs.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller("/")
@Slf4j
public class LoginController {

//     Logger logger = new Logger(Logger.GLOBAL_LOGGER_NAME)

//        @RequestMapping("")
        @GetMapping("")
    public ModelAndView loginPage() {
            return new ModelAndView("index")
                    .addObject("login", new LoginDTO());
        }

//    @RequestMapping(method = RequestMethod.POST, value = "/login")
//    same as below. Newer version


    @PostMapping("/login")

    public ModelAndView login(LoginDTO loginDTO ){
    //loginDTO is creating our method object dependencies dependency injection through inversion of control
        log.info("USER - EMAIL-----> {"+loginDTO.getEmail()+"} ");
        return new ModelAndView("profile")
                .addObject("dashboardMessage",
                        "Welcome, user with email: "+loginDTO.getEmail());
    }

}
