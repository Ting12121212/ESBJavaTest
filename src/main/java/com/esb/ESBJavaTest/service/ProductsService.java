package com.esb.ESBJavaTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.ESBJavaTest.model.DB_repository.ProductsRepository;
import com.esb.ESBJavaTest.model.entity.Products;
import com.esb.ESBJavaTest.model.entity.Users;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsDao;

	// =SELECT=========================================================

	// ====取得所有金融商品
	public List<Products> findAllProducts() {
		List<Products> products = productsDao.findAll();
		return products;
	}

	// ====依商品ID取得對應金融商品
	public Products findProductByID(Integer productNo) {
		Optional<Products> option = productsDao.findById(productNo);

		if (option.isPresent()) {
			return option.get();
		} else {
			Products error = new Products();
			error.setProductName("沒有這筆資料");
			return error;
		}
	}

}
