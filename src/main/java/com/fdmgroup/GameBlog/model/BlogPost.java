package com.fdmgroup.GameBlog.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer blogPostId;
	@ManyToOne
	private User author;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	private int likes;
	private LocalDate postedAt;
	//image
	
	public BlogPost(User author, String title, String content, int likes, LocalDate postedAt) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.postedAt = postedAt;
	}
	
	
	public Integer getBlogPostId() {
		return blogPostId;
	}

	public void setBlogPostId(Integer blogPostId) {
		this.blogPostId = blogPostId;
	}

	public User getAuthor() {
		return author;
	}	
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public LocalDate getPostedAt() {
		return postedAt;
	}
	public void setPostedAt(LocalDate postedAt) {
		this.postedAt = postedAt;
	}
	
}