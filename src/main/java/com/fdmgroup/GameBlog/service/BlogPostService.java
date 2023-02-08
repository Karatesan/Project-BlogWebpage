package com.fdmgroup.GameBlog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.repository.BlogPostRepository;

@Service
public class BlogPostService implements IBlogPostService {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	public BlogPost savePost (BlogPost blogPost) {
		if(blogPost.getBlogPostId() == null) {
			blogPost.setPostedAt(LocalDateTime.now());
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
