package com.wirtz.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.productservice.ProductBlock;
import com.wirtz.ecommerce.model.productservice.ProductService;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Controller

public class ProductController {

	private final static String SEARCH_PRODUCTS_VIEW = "ProductsSearch";
	private final static String SEARCH_RESULT_VIEW = "ProductsSearchResult";
	private final static String PARAM_PRODUCT_ID = "productId";
	private final static String PRODUCTS_ATT = "block";
	private final static String PRODUCT_VIEW = "Product";
	private final static String PRODUCTS_SEARCH_URL_PATTERN= "/products/search/%d/%d?keyWords=%s";

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public String getProducts() {
		return SEARCH_PRODUCTS_VIEW;
	}
	
	@GetMapping("products/{productId}")
	public ModelAndView getProduct(@PathVariable(PARAM_PRODUCT_ID) long id) throws InstanceNotFoundException {

		ModelAndView model = new ModelAndView(PRODUCT_VIEW);


			model.addObject("product", productService.findProduct(id));
	
		
		return model;

	}

	@GetMapping("/products/search/{startIndex}/{pageCount}")
	public String searchProducts(@RequestParam String keyWords, Model model, 
			@PathVariable int startIndex, 
			@PathVariable int pageCount) {

		System.out.println("/products/search");
		
		ProductBlock products= productService.findProductsBlockByKeyword(keyWords, startIndex, pageCount);
		
		products.setUrlPattern(PRODUCTS_SEARCH_URL_PATTERN);
		
		
		model.addAttribute(PRODUCTS_ATT, products);
		
		
		return SEARCH_RESULT_VIEW;
	}
	
	


}
