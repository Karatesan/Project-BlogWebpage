package com.fdmgroup.GameBlog.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.repository.BlogPostRepository;

public class BlogPostService implements IBlogPostService {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	public BlogPost savePost (BlogPost blogPost) {
		if(blogPost.getBlogPostId() == null) {
			blogPost.setPostedAt(LocalDate.now());
		}
		return blogPostRepository.save(blogPost);
	}
	
	public Optional<BlogPost> getPostById(Integer id){
		return blogPostRepository.findById(id);
	}

	public List<BlogPost> getAllPosts(){
		return blogPostRepository.findAll();
	}
	
	
}
