//package com.fdmgroup.GameBlog.service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.stereotype.Service;
//import com.fdmgroup.GameBlog.model.Comment;
//
//@Service
//public class CommentService {
//	
//	   public List<Comment> getArticleComments()
//	   {
//	      List<Comment> allCmnts = dummyComments();
//	      List<Comment> reorganizedCmnts = reorganizeComments(allCmnts);
//	      
//	      return reorganizedCmnts;
//	   }
//	   
//	   private List<Comment> reorganizeComments(List<Comment> allCmnts)
//	   {
//	      Map<Integer, Comment> mappedComments
//	         = sortCommentsIntoMap(allCmnts);
//	      
//	      addChildCommentsToParent(allCmnts, mappedComments);
//	      
//	      List<Comment> retVal = topMostComments(allCmnts);
//
//	      return retVal;
//	   }
//
//	   private List<Comment> topMostComments(List<Comment> allCmnts)
//	   {
//	      List<Comment> retVal = new ArrayList<Comment>();
//	   
//	      if (allCmnts != null)
//	      {
//	         for (Comment cmnt : allCmnts)
//	         {
//	            if (cmnt != null)
//	            {
//	               if (cmnt.getParentCommentId() == null || cmnt.getParentCommentId().equals(""))
//	               {
//	                  retVal.add(cmnt);
//	               }
//	            }
//	         }
//	      }
//	      
//	      return retVal;
//	   }
//
//	   private void addChildCommentsToParent(List<Comment> allCmnts, 
//	                Map<Integer, Comment> mappedComments)
//	   {
//	      if (allCmnts != null && mappedComments != null)
//	      {
//	         for (Comment cmnt : allCmnts)
//	         {
//	            if (cmnt != null)
//	            {
//	               String parentCmntId = cmnt.getParentCommentId();
//	               if (parentCmntId != null && !parentCmntId.equals("") && 
//	                                           parentCmntId.length() > 0)
//	               {
//	                  if (mappedComments.containsKey(parentCmntId))
//	                  {
//	                     Comment parentCmnt = mappedComments.get(parentCmntId);
//	                     if (parentCmnt != null)
//	                     {
//	                        parentCmnt.getChildComments().add(cmnt);
//	                     }
//	                  }
//	               }
//	            }
//	         }
//	      }
//	   }
//
//	   private Map<Integer, Comment> sortCommentsIntoMap(List<Comment> allCmnts)
//	   {
//	      Map<Integer, Comment> mappedComments  = new HashMap<Integer, Comment>();
//	      
//	      if (allCmnts != null)
//	      {
//	         for (Comment cmnt : allCmnts)
//	         {
//	            if (cmnt != null)
//	            {
//	               if (!mappedComments.containsKey(cmnt.getCommentId()))
//	               {
//	                  mappedComments.put(cmnt.getCommentId(), cmnt);
//	               }
//	            }
//	         }
//	      }
//	      
//	      return mappedComments;
//	   }
//	   
//	   private List<Comment> dummyComments()
//	   {
//	      List<Comment> retVal = new ArrayList<Comment>();
//	      
//	      Comment modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser1@goomail.com");
//	      modelAdd.setCommenterName("Test User1");
//	      modelAdd.setCommentId(0);
//	      modelAdd.setContent("The first comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId(null);
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser2@goomail.com");
//	      modelAdd.setCommenterName("Test User2");
//	      modelAdd.setCommentId(1);
//	      modelAdd.setContent("The first child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("05e6fe83ab3f4f3bbf2e5ab75eda277b");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser2@goomail.com");
//	      modelAdd.setCommenterName("Test User2");
//	      modelAdd.setCommentId(2);
//	      modelAdd.setContent("The second child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("05e6fe83ab3f4f3bbf2e5ab75eda277b");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser3@goomail.com");
//	      modelAdd.setCommenterName("Test User3");
//	      modelAdd.setCommentId(3);
//	      modelAdd.setContent("The first grand child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("b22b8a8cce0b4aa196d5e54e902be761");
//	      
//	      retVal.add(modelAdd);
//
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser3@goomail.com");
//	      modelAdd.setCommenterName("Test User3");
//	      modelAdd.setCommentId(4);
//	      modelAdd.setContent("The second grand child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("b22b8a8cce0b4aa196d5e54e902be761");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser3@goomail.com");
//	      modelAdd.setCommenterName("Test User3");
//	      modelAdd.setCommentId(5);
//	      modelAdd.setContent("The third grand child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("b22b8a8cce0b4aa196d5e54e902be761");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser3@goomail.com");
//	      modelAdd.setCommenterName("Test User3");
//	      modelAdd.setCommentId(6);
//	      modelAdd.setContent("The fourth grand child comment for this article");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("c2769bfd2d0a49a0920737d854e43c53");
//	      
//	      retVal.add(modelAdd);
//
//	      //----------------
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser3@goomail.com");
//	      modelAdd.setCommenterName("Test User3");
//	      modelAdd.setCommentId(7);
//	      modelAdd.setContent("This is a second comment on the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId(null);
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser5@goomail.com");
//	      modelAdd.setCommenterName("Test User5");
//	      modelAdd.setCommentId(8);
//	      modelAdd.setContent("Child comment #1 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("ef0d7c94fb6948f383835def70c09a79");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser5@goomail.com");
//	      modelAdd.setCommenterName("Test User5");
//	      modelAdd.setCommentId(9);
//	      modelAdd.setContent("Child comment #2 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("ef0d7c94fb6948f383835def70c09a79");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser5@goomail.com");
//	      modelAdd.setCommenterName("Test User5");
//	      modelAdd.setCommentId(10);
//	      modelAdd.setContent("Child comment #3 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("ef0d7c94fb6948f383835def70c09a79");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser6@goomail.com");
//	      modelAdd.setCommenterName("Test User6");
//	      modelAdd.setCommentId(11);
//	      modelAdd.setContent("Grand child comment #1 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("f0e383e91bb9456abf13d0dc1f7d1ba7");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser7@goomail.com");
//	      modelAdd.setCommenterName("Test User7");
//	      modelAdd.setCommentId(12);
//	      modelAdd.setContent("Grand child comment #2 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("8d26b047dedf4d948cc87b72fb55bba4");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser7@goomail.com");
//	      modelAdd.setCommenterName("Test User7");
//	      modelAdd.setCommentId(13);
//	      modelAdd.setContent
//	           ("Grand child comment #3 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("8d26b047dedf4d948cc87b72fb55bba4");
//	      
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser8@goomail.com");
//	      modelAdd.setCommenterName("Test User8");
//	      modelAdd.setCommentId(14);
//	      modelAdd.setContent("Great Grand child comment #1 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("c5de23d8609f4d819d235dc6867f7917");
//	      retVal.add(modelAdd);
//	      
//	      modelAdd = new Comment();
//	      modelAdd.setArticleId("525d346cbd784180bd09bc8a52be3e1a");
//	      modelAdd.setCommenterEmail("testuser8@goomail.com");
//	      modelAdd.setCommenterName("Test User8");
//	      modelAdd.setCommentId(15);
//	      modelAdd.setContent("Great Grand child comment #2 of the second comment of the same article.");
//	      modelAdd.setDate(LocalDate.now());
//	      modelAdd.setParentCommentId("1d8a871aebbe486595e3d9d3aecb8713");
//	      
//	      retVal.add(modelAdd);
//
//	      return retVal;
//	   }
//
//}
