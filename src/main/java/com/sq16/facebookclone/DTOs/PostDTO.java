package com.sq16.facebookclone.DTOs;

import com.sq16.facebookclone.Models.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO {
    private String contentBody;
    private List<CommentDTO> comments;
    private Users user;
}
