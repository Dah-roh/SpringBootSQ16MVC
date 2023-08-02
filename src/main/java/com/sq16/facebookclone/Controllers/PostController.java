package com.sq16.facebookclone.Controllers;

import com.sq16.facebookclone.DTOs.PostDTO;
import com.sq16.facebookclone.Models.Post;
import com.sq16.facebookclone.Models.Users;
import com.sq16.facebookclone.Services.PostService;
import com.sq16.facebookclone.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("/posts")
@Slf4j
public class PostController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/post")
    public ModelAndView viewPosts(@PathVariable("id") Long id){
        List<Post> postList = postService.findAllPostByUserId(id);
        return new ModelAndView("profile").addObject("postList", postList);
    }

    @PostMapping("/post")
    public ModelAndView savePost( PostDTO postDTO){
        Users user =  userService.findById(postDTO.getUser().getId());
        postDTO.setUser(user);
        postService.savePost(postDTO);
        List<Post> postList =  postService.findAllPostByUserId(postDTO.getUserId());
        log.info(" Here is this users post: "+ postList);
        //TODO: IF ERROR: REMEMBER: -> TO HANDLE WHAT HAPPENS AFTER SUCCESSFUL POSTING
        return new ModelAndView("profile").addObject("postList", postList);
    }
}
