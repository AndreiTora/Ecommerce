package com.wirtz.ecommerce.model.cartservice;

import java.util.List;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public interface CartService {
	
	List<Cartline> findCartlinesByUserId(Long id);
	
	void delete(Long id);
	
	void insert(Long productId, Long userId);
	
	 void update(Long cartlineId, Long userId, Long amount) throws InstanceNotFoundException;
}
