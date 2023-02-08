package com.fdmgroup.GameBlog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.GameBlog.model.ChildComment;
import com.fdmgroup.GameBlog.repository.ChildCommentRepository;

@Service
public class ChildCommentService {
	
	@Autowired
	private ChildCommentRepository childCommentRepo;
	
	public void save(ChildComment childComment) {
		childCommentRepo.save(childComment);
	}
	
	public Optional<ChildComment> getChildCommentById(Integer id){
		return childCommentRepo.findById(id);
	}
	
}
