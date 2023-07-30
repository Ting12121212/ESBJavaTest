package com.esb.ESBJavaTest.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {

	// PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private Integer no;

	@Column(name = "productName")
	private String productName;

	@Column(name = "price")
	private Integer price;

	@Column(name = "feeRate")
	private Double feeRate;

	@Column(name = "description")
	private String description;

	@Lob // 圖檔要加@Lob
	@Column(name = "photo")
	@JsonIgnore
	private byte[] photo;

	// ↓------------------------------------------
	// 有關聯之表單

	// Table: LikeList (Column: no)
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<LikeList> likeLists;
	// ↑-----------------------------------------

	// =====================================================
	// 建構子

	public Products() {
	}

	// ======================================================
	// getter setter
	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Double getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public List<LikeList> getLikeLists() {
		return likeLists;
	}

	public void setLikeLists(List<LikeList> likeLists) {
		likeLists = likeLists;
	}

}
