package com.fdmgroup.GameBlog.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.model.Comment;
import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.service.BlogPostService;
import com.fdmgroup.GameBlog.service.CommentService;

import com.fdmgroup.GameBlog.controller.MainController;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;

public class CommentComtroller {
	
	@Autowired
	private CommentService service;
	
	@Autowired
	private MainController mainController;

	@Autowired
	private DefaultUserDetailService userService;
	
	@Autowired
	private BlogPostService blogService;
	
	@PostMapping
	public String addComment(ModelMap model, @RequestParam String username, @RequestParam int articleId, @RequestParam String content) {
		
		User commenter = userService.findByUsername(username);
		LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		Optional<BlogPost> article = blogService.getPostById(articleId);
		
		Comment comment = new Comment(article.get(), content, commenter, date);
		
		service.save(comment);
		
		mainController.populateLoggedUserModel(model);
		
		return null;
	}
	
	@PostMapping
	public String removeComment(ModelMap model, @RequestParam int commentId) {
		
		
		
		return null;
	}
	
	 @PostMapping
	    public String showComments(@PathVariable int postId, ModelMap model) {
		 
	        BlogPost post = blogService.getPostById(postId).orElse(null);
	        if (post == null)
	            model.addAttribute("showCommentsError", "Error, post doesn't exist.");

	        List<Comment> comments = service.findAllCommentsFromPost(post);

	        model.addAttribute("comments", comments);
	        model.addAttribute("post", post);
	        mainController.populateLoggedUserModel(model);
	        
	        return "fragments/comments :: commentList";
	    }

}
