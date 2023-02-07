package com.fdmgroup.GameBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.GameBlog.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {

}
