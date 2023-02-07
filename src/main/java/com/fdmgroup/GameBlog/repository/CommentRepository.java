package com.fdmgroup.GameBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fdmgroup.GameBlog.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
