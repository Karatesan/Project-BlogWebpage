package com.fdmgroup.GameBlog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.service.BlogPostService;

@Controller
public class LikesController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private MainController mainController;
	
	  
	  @PostMapping("/likes/{blogPostId}")
	  public String submitRating(ModelMap model, @PathVariable int blogPostId) {
		  System.out.println("----------- / n---------------"); 
		Optional<BlogPost> blogPost = blogPostService.getPostById(blogPostId);
	    int currentLikes = blogPost.get().getLikes();
	    int updatedLikes = currentLikes+1;
	    blogPost.get().setLikes(updatedLikes);
	    System.out.println("PostID: "+blogPost + "; No. of likes: "+updatedLikes+ "----------- / n---------------");
	    blogPostService.save(blogPost.get());
	    model.addAttribute("blogPost", blogPost.get());
	    mainController.populateLoggedUserModel(model);
	    return "post";
	  }
	  
}

