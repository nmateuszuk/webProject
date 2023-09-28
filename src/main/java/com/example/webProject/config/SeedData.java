package com.example.webProject.config;

import com.example.webProject.models.Post;
import com.example.webProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;


    @Override
    public void run(String... args) throws Exception {
        List<Post> posts= postService.getAll();

        if(posts.size()==0){
            Post post1=new Post();
            post1.setTitle("title of post1");
            post1.setBody("This is post 1 <3");

            Post post2=new Post();
            post2.setTitle("title of post2");
            post2.setBody("This is post 2 <3");

            postService.save(post1);
            postService.save(post2);

        }

    }
}