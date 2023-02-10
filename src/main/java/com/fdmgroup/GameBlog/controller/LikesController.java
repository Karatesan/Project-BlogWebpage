package com.fdmgroup.GameBlog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.service.BlogPostService;

@Controller
public class LikesController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private MainController mainController;
	
	  
	  @GetMapping("/likes/{blogPostId}")
	  public String submitRating(ModelMap model, @PathVariable int blogPostId, @RequestParam int likes) {
		Optional<BlogPost> blogPost = blogPostService.getPostById(blogPostId);
	    int currentLikes = blogPost.get().getLikes();
	    int updatedLikes = currentLikes+1;
	    blogPost.get().setLikes(updatedLikes);
	    System.out.println("PostID: "+blogPost + "; No. of likes: "+updatedLikes);
	    blogPostService.save(blogPost.get());
	    
	    mainController.populateLoggedUserModel(model);
	    return "post";
	  }
	  
}

