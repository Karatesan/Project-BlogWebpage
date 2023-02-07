package com.fdmgroup.GameBlog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.service.BlogPostService;

public class BlogPostController {
	
	@Autowired
	private BlogPostService blogPostService;
	
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

}
