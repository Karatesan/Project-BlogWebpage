package com.fdmgroup.GameBlog.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.model.Comment;
import com.fdmgroup.GameBlog.model.User;
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
	
	
	@PostMapping
	public String addComment(ModelMap model, @RequestParam String username, @RequestParam BlogPost articleId, @RequestParam String content) {
		
		User commenter = userService.findByUsername(username);
		LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		
		Comment comment = new Comment(articleId, content, commenter, date);
		
		
		return null;
	}
	

}
