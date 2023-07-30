package com.esb.ESBJavaTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esb.ESBJavaTest.model.entity.LikeList;
import com.esb.ESBJavaTest.model.entity.Products;
import com.esb.ESBJavaTest.model.entity.Users;
import com.esb.ESBJavaTest.service.LikeListService;
import com.esb.ESBJavaTest.service.ProductsService;
import com.esb.ESBJavaTest.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LikeListController {

	@Autowired
	private LikeListService likeListService;

	@Autowired
	private ProductsService productService;

	@Autowired
	private UsersService userService;

	// ==========================================================

	// 依UserID顯示對應的喜好紀錄
	@GetMapping("/likeList/user/{userID}")
	public String showLikeListByUserID(@PathVariable Integer userID, Model model) {
		List<LikeList> likeList = likeListService.findLikeListsByUserID(userID);
		model.addAttribute("likeList", likeList);

		// 顯示喜好紀錄總金額
		int sum = 0;
		for (LikeList aLikeList : likeList) {
			sum += aLikeList.getProducts().getPrice() * aLikeList.getOrderName();
		}
		model.addAttribute("sum", sum);

		return "likeList";
	}

	// ==========================================================
	// 新增商品至喜好紀錄表
	@ResponseBody
	@PostMapping("/likeList/addToLikeList")
	public void addToLikeList(@RequestParam Integer productNo, @RequestParam Integer orderName) {

		Products product = productService.findProductByID(productNo);
		Users user = userService.findUserByID(3);

		LikeList likeList = new LikeList();
		likeList.setOrderName(orderName);
		likeList.setAccount(user.getAccount());
		likeList.setTotalFee((int) (product.getPrice() * likeList.getOrderName() * product.getFeeRate()));
		likeList.setTotalAmount(product.getPrice() * likeList.getOrderName() + likeList.getTotalFee());
		likeList.setUsers(user);
		likeList.setProducts(product);
		likeListService.addToLikeList(likeList);
	}
	// =======================================================
	// 依商品ID 刪除喜好紀錄表單一商品

//		// Thymeleaf寫法
//		@GetMapping("/shop/cart/deleteProduct")
//		public String deleteShopCartProduct(@RequestParam Integer productID, Model model, HttpSession session) {
//
//			Customer loggedInCustomer = (Customer) session.getAttribute("LoggedInCustomer");
//			shopCartService.deleteShopCartProductByID(loggedInCustomer.getCustomerID(), productID);
//
//			return "redirect:/shop/cart/customer/" + loggedInCustomer.getCustomerID();
//		}

}
