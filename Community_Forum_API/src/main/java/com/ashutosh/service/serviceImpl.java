package com.ashutosh.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashutosh.AppConstants.AppConstants;
import com.ashutosh.binding.commentBinding;
import com.ashutosh.binding.postBinding;
import com.ashutosh.binding.reactionBinding;
import com.ashutosh.binding.updatePostBinding;
import com.ashutosh.entity.Comment;
import com.ashutosh.entity.Post;
import com.ashutosh.entity.Reaction;
import com.ashutosh.repo.commentRepo;
import com.ashutosh.repo.instructorRepo;
import com.ashutosh.repo.postRepo;
import com.ashutosh.repo.reactionRepo;
import com.ashutosh.repo.studentRepo;
@Service
public class serviceImpl implements service {
	
	                  @Autowired
	                  postRepo pRepo;
	                  
	                  @Autowired
	                  studentRepo sRepo;
	                  
	                  @Autowired
	                  instructorRepo insRepo;
	                  
	                  @Autowired
	                  commentRepo comRepo;
	                  
	                  @Autowired
	                  reactionRepo reactRepo;

	@Override
	public String createPost(postBinding data) {
		            Post post= new Post();
		             BeanUtils.copyProperties(data, post);
		             pRepo.save(post);
                                 
		return AppConstants.sucess;
	}

	@Override
	public boolean deletePost(Long postId) {
		 Post post = pRepo.getPostById(postId);
		               pRepo.delete(post);
		return true;
	}

	@Override
	public boolean updatePost(updatePostBinding data) {
		          Long id  = data.getId();
		     Post post =        pRepo.getPostById(id);
		     BeanUtils.copyProperties(data, post);
             pRepo.save(post);
		                   
		return true;
	}

	@Override
	public boolean addComment(commentBinding data) {
		              Long postId = data.getPostId() ;
		          Post post =        pRepo.getPostById(postId);
		                  Comment comment = new Comment();
		                     BeanUtils.copyProperties(post, comment);
		                     comment.setPost(post);
		                    comRepo.save(comment) ;
		                  
		return true;
	}

	@Override
	public boolean react(reactionBinding data) {
		           Long postId = data.getPostId();
		           Post post =        pRepo.getPostById(postId);
		           Reaction react = new Reaction();
		            BeanUtils.copyProperties(data, react);
		            react.setPost(post);
		            reactRepo.save(react);
		            
		           
		return true;
	}

	@Override
	public List<Post> getAllPost() {
		List<Post> posts = pRepo.findAllByOrderByIdDesc();
		return posts;
	}

}
