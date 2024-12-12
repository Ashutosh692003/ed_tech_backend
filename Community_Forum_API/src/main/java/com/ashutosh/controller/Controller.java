package com.ashutosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh.binding.commentBinding;
import com.ashutosh.binding.postBinding;
import com.ashutosh.binding.reactionBinding;
import com.ashutosh.binding.updatePostBinding;
import com.ashutosh.entity.Post;
import com.ashutosh.service.service;

@RestController
public class Controller {
	
	
	 @Autowired
	 service serv;
	 
	 @PostMapping("/createPost")
	 public ResponseEntity<String> createPost( @RequestBody postBinding data){
		    String resp  =    serv.createPost(data);
		     return new ResponseEntity<>(resp,HttpStatus.CREATED);
	 }
	 
	  @GetMapping("/deletePost")
	 public boolean deletePost(@RequestParam("postId") Long postId) {
		         boolean b =   serv.deletePost(postId);
		         return b;
	 }
	  
	   @PostMapping("/updatePost")
	  public boolean updatePost(@RequestBody updatePostBinding data) {
		 boolean b =    serv.updatePost(data);
		 return b;
		  
	  }
	   @PostMapping("/addComment")
	   public boolean addComment( @RequestBody commentBinding data) {
		    
		 boolean b =    serv.addComment(data);
		  return b;
	   }
	    
	   @PostMapping("/react")
	   public boolean react(@RequestBody reactionBinding react) {
		     boolean b =        serv.react(react);
		     return b;
	   }
        @GetMapping("/loadPosts")
        public List<Post> loadPosts(){
        	List<Post>  posts=   serv.getAllPost();
        	return posts;
        }
}
