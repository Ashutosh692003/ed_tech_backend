package com.ashutosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashutosh.entity.Reaction;

public interface reactionRepo  extends JpaRepository<Reaction,Long>{

}
