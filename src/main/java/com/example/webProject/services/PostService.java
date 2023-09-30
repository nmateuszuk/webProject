package com.example.webProject.services;

import com.example.webProject.models.Comment;
import com.example.webProject.models.Post;
import com.example.webProject.repositories.CommentRepository;
import com.example.webProject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    public Optional<Post> getPostById(Long id){
        return  postRepository.findById(id);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }

    public Post save(Post post){
        if(post.getId()==null){
            post.setCreatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }

    public Comment save(Comment comment){
        if(comment.getCommentId()==null){
            comment.setCreatedAt(LocalDateTime.now());
        }
        return commentRepository.save(comment);
    }

    public Comment[] getCommentsByPostId(Long postId) {
        return commentRepository.findCommentsByPost_Id(postId);
    }
}
