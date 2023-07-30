package com.esb.ESBJavaTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esb.ESBJavaTest.model.DB_repository.LikeListRepository;
import com.esb.ESBJavaTest.model.entity.LikeList;

@Service
public class LikeListService {

	@Autowired
	private LikeListRepository likeListDao;

	// =SELECT=========================================================

	// 取得所有喜好紀錄
	public List<LikeList> findAllLikeLists() {
		List<LikeList> likeLists = likeListDao.findAll();
		return likeLists;
	}

	// 依User ID取得對應喜好紀錄
	public List<LikeList> findLikeListsByUserID(Integer userID) {
		List<LikeList> likeLists = likeListDao.findLikeListsByUserID(userID);
		return likeLists;
	}

	// =INSERT=============================================
	
	// 新增商品至喜好紀錄表
	public void addToLikeList(LikeList likeList) {
		likeListDao.save(likeList);
	}

	// =DELETE=============================================
	// 依客人&商品ID 刪除喜好紀錄表單一商品
		@Transactional
		public Integer deleteLikeListByID(Integer userID, Integer productNo) {
			Integer result = likeListDao.deleteLikeListByID(userID, productNo);
			return result;
		}

}
