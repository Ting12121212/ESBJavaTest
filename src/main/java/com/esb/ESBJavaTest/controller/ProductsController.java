package com.esb.ESBJavaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esb.ESBJavaTest.model.entity.Products;
import com.esb.ESBJavaTest.service.ProductsService;

@Controller
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	// ==========================================================

	// 顯示所有金融商品
	@GetMapping("/products/allProducts")
	@ResponseBody
	public List<Products> showAllProducts() {
		List<Products> productList = productsService.findAllProducts();
		return productList;
	}

}
