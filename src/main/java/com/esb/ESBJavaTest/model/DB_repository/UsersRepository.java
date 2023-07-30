package com.esb.ESBJavaTest.model.DB_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esb.ESBJavaTest.model.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	

}
