package com.example.webProject.controlers;

import com.example.webProject.models.Post;
import com.example.webProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/api/post", produces = "application/json")
    public Post home(){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO,"post 1 get");
        Post post= postService.getById(1L).get();
        return post;
    }

    @GetMapping(value = "/api/post/latest", produces = "application/json")
    public Post[] homeLatest(){
        Logger.getLogger(HomeController.class.getName()).log(Level.INFO,"post 1 get");
        return postService.getAll().toArray(new Post[0]);
    }

}
