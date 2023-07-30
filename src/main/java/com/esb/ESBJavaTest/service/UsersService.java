package com.esb.ESBJavaTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.ESBJavaTest.model.DB_repository.UsersRepository;
import com.esb.ESBJavaTest.model.entity.Products;
import com.esb.ESBJavaTest.model.entity.Users;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersDao;

	// =SELECT=========================================================
	
	// ====取得所有客戶
	public List<Users> findAllUsers() {
		List<Users> users = usersDao.findAll();
		return users;
	}
	
	// ====客戶ID取得對應User
		public Users findUserByID(Integer userID) {
			Optional<Users> option = usersDao.findById(userID);

			if (option.isPresent()) {
				return option.get();
			} else {
				Users error = new Users();
				error.setUserName("沒有這筆資料");
				return error;
			}
		}

}
