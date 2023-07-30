package com.esb.ESBJavaTest.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	// PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userID")
	private Integer userID;

	@Column(name = "userName")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "account")
	private String account;

	@Column(name = "account2")
	private String account2;

	// ↓------------------------------------------
	// 有關聯之表單

	// Table: LikeList (Column: userID)
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
//	@JsonIgnore
	private List<LikeList> LikeLists;
	// ↑-----------------------------------------

	
	// =====================================================
	// 建構子

	public Users() {
	}
	
	// ======================================================
	// getter setter

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount2() {
		return account2;
	}

	public void setAccount2(String account2) {
		this.account2 = account2;
	}

	public List<LikeList> getLikeLists() {
		return LikeLists;
	}

	public void setLikeLists(List<LikeList> likeLists) {
		LikeLists = likeLists;
	}

}
