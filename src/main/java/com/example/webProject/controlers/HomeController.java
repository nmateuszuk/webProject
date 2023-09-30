package com.example.webProject.controlers;

import com.example.webProject.models.Comment;
import com.example.webProject.models.Post;
import com.example.webProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/api/post/{id}", produces = "application/json")
    public Post home(@PathVariable("id") Long id){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO,"post " +  id + " got");
        Post post= postService.getPostById(id).get();
        return post;
    }

    @GetMapping(value = "/api/post/latest", produces = "application/json")
    public Post[] homeLatest(){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO,"post 1 get");
        return postService.getAll().toArray(new Post[0]);
    }

    @PostMapping(value = "/api/post/write", produces = "application/json")
    public void writePost(@RequestBody Post post){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "got post to save " + post.getTitle());
        postService.save(post);
    }

    @GetMapping(value = "/api/post/{postId}/comments", produces = "application/json")
    public Comment[] currentPostComments(@PathVariable("postId") Long postId){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "getting comments to " + postId);
        return postService.getCommentsByPostId(postId);
    }

    @PostMapping(value = "/api/post/{postId}/write_comment", produces = "application/json")
    public void writeComment(  @PathVariable("postId") Long postId, @RequestBody Comment comment ){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "got comment to save from" + comment.getUserName());
        postService.save(comment);
    }

}
