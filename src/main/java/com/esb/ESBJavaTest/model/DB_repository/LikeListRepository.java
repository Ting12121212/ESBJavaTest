package com.esb.ESBJavaTest.model.DB_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esb.ESBJavaTest.model.entity.LikeList;

public interface LikeListRepository extends JpaRepository<LikeList, Integer> {
	
	// 依User ID找對應的喜好紀錄
		@Query("from LikeList where users.userID = :userID")
		public List<LikeList> findLikeListsByUserID(@Param(value = "userID") Integer userID);
}
