package com.fdmgroup.GameBlog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdmgroup.GameBlog.model.BlogPost;
import com.fdmgroup.GameBlog.repository.BlogPostRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SearchingServiceTest {
	

	@Autowired
	private BlogPostRepository blogPostRepository;
	
	@Autowired
	private SearchingService searchingService;
	
	private BlogPost blogPost1;
	private BlogPost blogPost2;
	private BlogPost blogPost3;
	private BlogPost blogPost4;
	
	@Before
	public void setUp() {
		blogPost1 = new BlogPost("Hello World", "A basic hello world example", null, null);
		blogPost2 = new BlogPost("Hello", "A simple hello greeting", null, null);
		blogPost3 = new BlogPost("How to write a test", "A guide to writing tests", null, null);
		blogPost4 = new BlogPost("Hello again", "Another hello greeting", null, null);
		
		blogPostRepository.saveAll(Arrays.asList(blogPost1, blogPost2, blogPost3, blogPost4));
	}
	
	@Test
	public void testFindPostsByTitle_withStartingWith() {
		List<BlogPost> foundPosts = searchingService.findPostsByTitle("Hello");
		
		assertEquals(2, foundPosts.size());
		assertTrue(foundPosts.contains(blogPost1));
		assertTrue(foundPosts.contains(blogPost2));
	}
	
	@Test
	public void testFindPostsByTitle_withEndingWith() {
		List<BlogPost> foundPosts = searchingService.findPostsByTitle("again");
		
		assertEquals(1, foundPosts.size());
		assertTrue(foundPosts.contains(blogPost4));
	}
	
	@Test
	public void testFindPostsByTitle_withContaining() {
		List<BlogPost> foundPosts = searchingService.findPostsByTitle("write a");
		
		assertEquals(1, foundPosts.size());
		assertTrue(foundPosts.contains(blogPost3));
	}
	
	@Test
	public void testFindPostsByTitle_withNoneMatching() {
		List<BlogPost> foundPosts = searchingService.findPostsByTitle("test");
		
		assertEquals(0, foundPosts.size());
	}

}
