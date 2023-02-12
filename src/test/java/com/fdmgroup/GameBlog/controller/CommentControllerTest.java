package com.fdmgroup.GameBlog.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.fdmgroup.GameBlog.service.BlogPostService;
import com.fdmgroup.GameBlog.service.CommentService;



@SpringBootTest(classes = { CommentController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@ContextConfiguration(classes = Blog2manProjectApplication.class)


public class CommentControllerTest {
	
	@MockBean
	private CommentService service;
	
	@MockBean BlogPostService blogService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	Comment mockComment;
	
	@Mock
	BlogPost mockPost;
	

	
//	@Test
//	public void test1() throws Exception {
//	
//		//when(blogService.getPostById(1)).thenReturn(Optional.ofNullable(mockPost));
//		
//		mockMvc.perform(post("/showAllComments").param("username", "reader").param("articleId", "1").param("content", "test"))
//				.andExpect(status().isOk()).andExpect(view().name("post"));
//		
//		//verify(service,times(1)).save("Car");
//	}
	

}
