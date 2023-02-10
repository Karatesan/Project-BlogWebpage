package com.fdmgroup.GameBlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.GameBlog.model.BlogPost;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
	
	List<BlogPost> findByTitleIgnoreCaseContaining(String title);
	List<BlogPost> findByTitleIgnoreCaseStartingWith(String title);
	List<BlogPost> findByTitleIgnoreCaseEndingWith(String title);

}
