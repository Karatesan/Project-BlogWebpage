package com.fdmgroup.GameBlog.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogEntry {
	
	@Id
	@GeneratedValue
	private int blogEntryId;
	@ManyToOne
	private User author;
	private String title;
	private String content;
	private int likes;
	private LocalDate postDate;
	
	public BlogEntry() {}
	
	
	public BlogEntry(User author, String title, String content, int likes, LocalDate postDate) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
		this.likes = likes;
		this.postDate = postDate;
	}
	public int getBlogEntryId() {
		return blogEntryId;
	}
	public void setBlogEntryId(int blogEntryId) {
		this.blogEntryId = blogEntryId;
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
	public LocalDate getPostDate() {
		return postDate;
	}
	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}
	
	//image
	
	
	

}
