package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Comment;

public interface commentRepo extends JpaRepository<Comment,Long> {

}
