package com.fdmgroup.GameBlog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
<<<<<<< Updated upstream

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
=======
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
>>>>>>> Stashed changes

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
<<<<<<< Updated upstream
import org.mockito.Mockito;
=======
>>>>>>> Stashed changes
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.model.User;
import com.fdmgroup.GameBlog.security.DefaultUserDetailService;
import com.fdmgroup.GameBlog.service.BlogPostService;
<<<<<<< Updated upstream
import com.fdmgroup.GameBlog.util.BlogPostPictureUtil;
=======
>>>>>>> Stashed changes

@ExtendWith(MockitoExtension.class)
public class BlogPostControllerTest {


<<<<<<< Updated upstream
	@Mock
	private DefaultUserDetailService defaultUserDetailService;
	
	@Mock
	private BlogPostService blogPostService;
	
	@Mock
	private ModelMap model;
	
	@Mock
	private BlogPostPictureUtil blogPostPictureUtil;
	
	@Mock
	private MultipartFile mainMultipartFile;
	
	@InjectMocks
	private BlogPostController mainController;
	
	@Test
	public void testSaveNewPost() throws IOException {
		String title = "Test Title";
		String content = "Test Content";
		String authorUsername = "Test User";
		User author = new User();
		List<BlogPost> allPosts = new ArrayList<>();
		BlogPost newPost = new BlogPost(author, title, content, 0, LocalDateTime.now());
		String picName = "test.jpg";
		String uploadDir = "./blogPost-pictures/" + newPost.getBlogPostId();
		
		Mockito.when(defaultUserDetailService.findByUsername(authorUsername)).thenReturn(author);
		Mockito.when(mainMultipartFile.getOriginalFilename()).thenReturn(picName);
		Mockito.when(blogPostService.savePost(newPost)).thenReturn(newPost);
		Mockito.when(blogPostService.getAllPosts()).thenReturn(allPosts);
		
		String result = mainController.saveNewPost(model, title, content, authorUsername, mainMultipartFile);
		
		Mockito.verify(defaultUserDetailService, Mockito.times(1)).findByUsername(authorUsername);
		Mockito.verify(blogPostService, Mockito.times(1)).savePost(newPost);
		Mockito.verify(blogPostService, Mockito.times(1)).getAllPosts();
		Mockito.verify(blogPostPictureUtil, Mockito.times(1)).savePicture(uploadDir, picName, mainMultipartFile);
		Mockito.verify(model, Mockito.times(1)).addAttribute("allPosts", allPosts);
		Mockito.verify(mainController, Mockito.times(1)).populateLoggedUserModel(model);
		
		assertEquals("index", result);
	}

=======
	@InjectMocks
	BlogPostController blogPostController;
	
	@Mock
	DefaultUserDetailService defaultUserDetailService;
	
	@Mock
	BlogPostService blogPostService;
	
	@Mock
	MainController mainController;
	
	@Mock
	MultipartFile mainMultipartFile;
	
	@Test
	public void saveNewPostTest() throws IOException {
		User author = new User();
		when(defaultUserDetailService.findByUsername("username")).thenReturn(author);
		when(mainMultipartFile.getOriginalFilename()).thenReturn("picture.jpg");
		ModelMap model = new ModelMap();
		String result = blogPostController.saveNewPost(model, "title", "content", "username", mainMultipartFile);
		verify(defaultUserDetailService, times(1)).findByUsername("username");
		verify(blogPostService, times(1)).savePost(any(BlogPost.class));
		verify(mainMultipartFile, times(1)).getOriginalFilename();
		verify(mainController, times(1)).populateLoggedUserModel(model);
		verify(blogPostService, times(1)).getAllPosts();
		assertEquals("index", result);
		assertEquals(model.get("allPosts"), blogPostService.getAllPosts());
	}
>>>>>>> Stashed changes
}

