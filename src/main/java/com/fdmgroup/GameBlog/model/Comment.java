//package com.fdmgroup.GameBlog.model;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
//public class Comment {
//	@Id
//	@GeneratedValue
//	private int commentId;
//	private String articleId;
//	private String parentCommentId;
//	private List<Comment> childComments;
//	private String content;
//	private String commenterName;
//	private String commenterEmail;
//	private LocalDate date;
//
//	public String getArticleId() {
//		return articleId;
//	}
//
//	public void setArticleId(String articleId) {
//		this.articleId = articleId;
//	}
//
//	public int getCommentId() {
//		return commentId;
//	}
//
//	public void setCommentId(int commentId) {
//		this.commentId = commentId;
//	}
//
//	public String getParentCommentId() {
//		return parentCommentId;
//	}
//
//	public void setParentCommentId(String parentCommentId) {
//		this.parentCommentId = parentCommentId;
//	}
//
//	public List<Comment> getChildComments() {
//		return childComments;
//	}
//
//	public void setChildComments(List<Comment> childComments) {
//		this.childComments = childComments;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getCommenterName() {
//		return commenterName;
//	}
//
//	public void setCommenterName(String commenterName) {
//		this.commenterName = commenterName;
//	}
//
//	public String getCommenterEmail() {
//		return commenterEmail;
//	}
//
//	public void setCommenterEmail(String commenterEmail) {
//		this.commenterEmail = commenterEmail;
//	}
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//}
