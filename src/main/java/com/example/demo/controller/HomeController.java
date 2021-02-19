package com.example.demo.controller;

import com.example.demo.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getAllPost(Model model)
    {
        //business logic
        ArrayList<Post> posts=new ArrayList<>();
        Post post1=new Post();
        post1.setTitle("SmartPhone");
        post1.setBody("iPhone are not better than Android");
        post1.setDate(new Date());


        Post post2=new Post();
        post2.setTitle("Beauty");
        post2.setBody("Gomez has started his own makeup");
        post2.setDate(new Date());



        Post post3=new Post();
        post3.setTitle("Technology");
        post3.setBody("Tesla CEO is Promoting SpaceX");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
//gave post to view
        model.addAttribute("posts",posts);
        return "index";

    }

}
