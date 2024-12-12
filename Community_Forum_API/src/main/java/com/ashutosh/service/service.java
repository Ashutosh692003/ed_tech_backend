package com.ashutosh.service;

import java.util.List;

import com.ashutosh.binding.commentBinding;
import com.ashutosh.binding.postBinding;
import com.ashutosh.binding.reactionBinding;
import com.ashutosh.binding.updatePostBinding;
import com.ashutosh.entity.Post;

public interface service {

	 public String createPost(postBinding data);
	 public boolean deletePost(Long postId);
	 public boolean updatePost(updatePostBinding data);
	 public boolean addComment(commentBinding data);
	 public boolean react(reactionBinding data);
	 public List<Post> getAllPost();
	 
	 
}
