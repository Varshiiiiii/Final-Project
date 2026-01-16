package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Comment;
import com.excelr.entity.Post;
import com.excelr.repository.CommentRepository;
import com.excelr.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// 1 . Save new Comment
	@Override
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public List<Comment> getAllComments(){
		return commentRepository.findAll();
	}
	
	// 2 . Get Comments by PostId
	@Override
	public List<Comment> getCommentsByPostId(Integer postId){
		
		Post post = postRepository.findByUserId(postId).orElseThrow(() -> new RuntimeException("Post Not Found"));
		
		return commentRepository.findByPost(post);
	}
}
