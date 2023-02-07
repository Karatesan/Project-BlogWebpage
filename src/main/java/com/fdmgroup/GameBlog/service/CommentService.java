package com.fdmgroup.GameBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdmgroup.GameBlog.model.Comment;
import com.fdmgroup.GameBlog.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
	

}
