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
	
	//image
	
	
	

}
