package com.wirtz.ecommerce.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.ecommerce.model.cartservice.CartService;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Controller
public class CartController {
	
	private final static String CARTLINES_VIEW = "CartShop";
	private final static String PARAM_PRODUCT_ID = "productId";

	@Autowired 
	CartService cartService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/cart")
	public ModelAndView getCartlines() {

		ModelAndView model = new ModelAndView(CARTLINES_VIEW);

		model.addObject("products", cartService.findCartlinesByUserId((Long) session.getAttribute("userProfileId")));
		
		return model;

	}
	
	@GetMapping("cart/add/{productId}")
	public String insert(@PathVariable(PARAM_PRODUCT_ID) long id) throws InstanceNotFoundException {
			cartService.insert(id, (Long) session.getAttribute("userProfileId"));
			
			return "redirect:/products";
	}
	
	@GetMapping("cart/delete/{productId}")
	public String remove(@PathVariable(PARAM_PRODUCT_ID) long id) throws InstanceNotFoundException {

		cartService.delete(id);

		return "redirect:/cart";

	}
	
	@GetMapping("cart/update/{cartlineId}/{amount}")
	public String update(@PathVariable("amount") long amount, @PathVariable("cartlineId") long id) throws InstanceNotFoundException {

		cartService.update(id, (Long) session.getAttribute("userProfileId"), amount);

		return "redirect:/cart";

	}

}
