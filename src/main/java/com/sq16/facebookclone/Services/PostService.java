package com.sq16.facebookclone.Services;

import com.sq16.facebookclone.DTOs.PostDTO;
import com.sq16.facebookclone.Models.Post;

import java.util.List;

public interface PostService {
    Post savePost(PostDTO postDTO);

    List<Post> findAllPostByUserId(Long id);
}
