package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    // GET request to "/users/login
    private UserService userService = new UserService();
    private PostService postService = new PostService();

    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }

    //Post request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user) {
        //check if credential match
        if (userService.login(user)) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }
    }

    //registration user
    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        return "redirect:/users/login";
    }
@RequestMapping("/users/logout")
    public String userLogout(Model model)
{
    List<Post> posts=postService.getAllPosts();
    model.addAttribute("posts",posts);
    return "redirect:/";
}

}