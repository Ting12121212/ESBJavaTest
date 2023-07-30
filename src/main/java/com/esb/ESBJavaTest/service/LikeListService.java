package com.esb.ESBJavaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.ESBJavaTest.model.DB_repository.LikeListRepository;
import com.esb.ESBJavaTest.model.entity.LikeList;

@Service
public class LikeListService {

	@Autowired
	private LikeListRepository LikeListDao;

	// =SELECT=========================================================

	// 取得所有喜好紀錄
	public List<LikeList> findAllLikeLists() {
		List<LikeList> likeLists = LikeListDao.findAll();
		return likeLists;
	}

	// 依User ID取得對應喜好紀錄
	public List<LikeList> findLikeListsByUserID(Integer userID) {
		List<LikeList> likeLists = LikeListDao.findLikeListsByUserID(userID);
		return likeLists;
	}

	// =INSERT=============================================
	
	// 新增商品至喜好紀錄表
	public void addToLikeList(LikeList likeList) {
		LikeListDao.save(likeList);
	}

	// ==============================================

}
