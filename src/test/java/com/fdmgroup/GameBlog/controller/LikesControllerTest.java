package com.fdmgroup.GameBlog.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.GameBlog.Blog2manProjectApplication;
import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.model.Comment;
import com.fdmgroup.GameBlog.model.LikeDislike;
import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;
import com.fdmgroup.GameBlog.service.BlogPostService;
import com.fdmgroup.GameBlog.service.CommentService;
import com.fdmgroup.GameBlog.service.LikeDislikeService;

@SpringBootTest(classes = { LikesController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = Blog2manProjectApplication.class)
public class LikesControllerTest {
	
	@MockBean
	private CommentService service;
	
	@MockBean BlogPostService blogService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private LikeDislikeService likeService;
	
	@Autowired
	private DefaultUserDetailService userService;
	
	@Mock
	Comment mockComment;
	
	@Mock
	BlogPost mockPost;
	
	@Mock
	User mockUser;
	
	@Mock
	LikeDislike mockLike;
	
	
//	@Test
//	public void test1() {
//		
//		when(blogService.getPostById(1)).thenReturn(Optional.ofNullable(mockPost));
//		when(userService.findByUsername("reader")).thenReturn(mockUser);
//		when(likeService.findByUserAndBlog(mockUser, mockPost)).thenReturn(Optional.ofNullable(mockLike));
//		
//		mockMvc.perform(post("/likes/1").param("username", "reader").param("articleId", "1").param("content", "test"))
//				.andExpect(status().isOk()).andExpect(view().name("post"));
//		
//		//verify(service,times(1)).save("Car");
//		
//	}
	

}
