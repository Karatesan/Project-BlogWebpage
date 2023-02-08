package com.fdmgroup.GameBlog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
//	@Autowired
//	private User user;
	
	@Autowired
	DefaultUserDetailService defaultUserDetailService;
	
	@Autowired
	MainController mainController;
	
	@GetMapping("/posts/new")
	public String createNewPost(ModelMap model) {
//		Optional<User> optionalUser = defaultUserDetailService.findByEmail("to fill later");
//		if (optionalUser.isPresent()) {
//			BlogPost newBlogPost = new BlogPost();
//			newBlogPost.setAuthor(optionalUser.get());
//			model.addAttribute("newPost", newBlogPost);
//			return "404";
//		}
//		else {
			mainController.populateLoggedUserModel(model);
			return "post_new";
			
		//}
	}

	@PostMapping("/posts/new")
	public String saveNewPost (@ModelAttribute BlogPost blogPost) {
		
		//tutaj lepiej zamias model atrtribute uzyj @request param dla ukrytych wartosci  itych wpisanych 
		//w formie czyli authorUsername, title i content. Zmienilem w blog post i service na localDateTime - zawiera tez godziny
		blogPostService.savePost(blogPost);
		return "redirect:/posts/"+blogPost.getBlogPostId();
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
	
}
