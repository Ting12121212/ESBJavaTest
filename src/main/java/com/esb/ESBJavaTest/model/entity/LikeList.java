package com.esb.ESBJavaTest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LikeList")
public class LikeList {

	// PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sn")
	private Integer sn;

	@Column(name = "orderName")
	private Integer orderName;

	@Column(name = "account")
	private String account;

	@Column(name = "totalFee")
	private Integer totalFee;

	@Column(name = "totalAmount")
	private Integer totalAmount;

	// ↓------------------------------------------
	// FK欄位

	// Column: userID (Table: Users)
	@ManyToOne
	@JoinColumn(name = "userID", referencedColumnName = "userID")
	@JsonIgnore
	private Users users;

	// Column: productNo (Table: Products)
	@ManyToOne
	@JoinColumn(name = "productNo", referencedColumnName = "no")
//	@JsonIgnore
	private Products products;
	// ↑-----------------------------------------

	
	// =====================================================
	// 建構子

	public LikeList() {
	}
	
	// ======================================================
	// getter setter
	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
	}

	public Integer getOrderName() {
		return orderName;
	}

	public void setOrderName(Integer orderName) {
		this.orderName = orderName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
