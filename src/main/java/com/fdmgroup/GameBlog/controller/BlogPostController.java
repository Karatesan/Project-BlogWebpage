package com.fdmgroup.GameBlog.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;
import com.fdmgroup.GameBlog.service.BlogPostService;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	DefaultUserDetailService defaultUserDetailService;
	
	@Autowired
	MainController mainController;
	
	@GetMapping("/posts/new")
	public String createNewPost(ModelMap model) {
		mainController.populateLoggedUserModel(model);
		return "post_new";
	}		

	@PostMapping("/posts/new")
	public String saveNewPost (ModelMap model, @RequestParam String title, @RequestParam String content, @RequestParam String authorUsername) {
		User author = defaultUserDetailService.findByUsername(authorUsername);
		LocalDateTime time = LocalDateTime.now();
		BlogPost newPost = new BlogPost(author, title, content, 0, time);
		blogPostService.savePost(newPost);
		mainController.populateLoggedUserModel(model);
		return "index";
	}
	
	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable Integer id, Model model) {
		Optional<BlogPost> optionalBlogPost = blogPostService.getPostById(id); //find post by id
		// if post exists, push it into model
		if (optionalBlogPost.isPresent()) {
			BlogPost blogPost = optionalBlogPost.get();
			model.addAttribute("blogPost", blogPost);
			return "post";
		}
		else {
			return "404";
		}
	}
	
    @GetMapping("/posts/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getPostForEdit(@PathVariable Integer id, Model model) {

        // find post by id
        Optional<BlogPost> optionalBlogPost = blogPostService.getPostById(id);
        // if post exist put it in model
        if (optionalBlogPost.isPresent()) {
           BlogPost blogPost = optionalBlogPost.get();
            model.addAttribute("blogPost", blogPost);
            return "post_edit";
        } else {
            return "404";
        }
    }

    @GetMapping("/posts/{id}/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletePost(@PathVariable Integer id) {
        // find post by id
        Optional<BlogPost> optionalBlogPost = blogPostService.getPostById(id);
        if (optionalBlogPost.isPresent()) {
            BlogPost blogPost = optionalBlogPost.get();
            blogPostService.delete(blogPost);
            return "redirect:/";
        } else {
            return "404";
        }
    }
}
