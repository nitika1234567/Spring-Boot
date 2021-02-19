package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    //Singleton
    private static ArrayList<Post> POSTS=new ArrayList<>();
    static
    {
        Post post1=new Post();
        post1.setTitle("World Wide");
        post1.setBody("A news in utt reported heavy floods in UK districts.");
        post1.setDate(new Date());
        POSTS.add(post1);



        Post post2=new Post();
        post2.setTitle("Music");
        post2.setBody("A Music list");
        post2.setDate(new Date());
        POSTS.add(post2);



        Post post3=new Post();
        post3.setTitle("Technology");
        post3.setBody("Apple new ios 14.5");
        post3.setDate(new Date());
        POSTS.add(post3);


        Post post4=new Post();
        post4.setTitle("National");
        post4.setBody("COVID vaccine");
        post4.setDate(new Date());
        POSTS.add(post4);

    }
    public ArrayList<Post> getAllPosts()
    {
      return POSTS;
    }
    public void createPost(Post newPost)
    {
      POSTS.add(newPost);
    }
}
