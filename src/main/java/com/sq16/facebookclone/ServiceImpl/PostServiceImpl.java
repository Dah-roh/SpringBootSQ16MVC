package com.sq16.facebookclone.ServiceImpl;

import com.sq16.facebookclone.DTOs.PostDTO;
import com.sq16.facebookclone.Models.Post;
import com.sq16.facebookclone.Repositories.PostRepository;
import com.sq16.facebookclone.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post savePost(PostDTO postDTO){
//        Post post =  new Post(postDTO);
        return postRepository.save(new Post(postDTO));
    }
    @Override
    public List<Post> findAllPostByUserId(Long id) {
        return postRepository.findAllByUserId(id);
    }
}
