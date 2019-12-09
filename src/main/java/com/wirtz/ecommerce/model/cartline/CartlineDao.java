package com.wirtz.ecommerce.model.cartline;

import java.util.List;

import com.wirtz.ecommerce.modelutil.dao.GenericDao;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public interface CartlineDao extends GenericDao<Cartline, Long> {
	
	List<Cartline> findCartlinesByUserId(Long id);
	
	void insert(Long productId, Long userId);
	
	void update(Long productId, Long userId, Long amount) throws InstanceNotFoundException;
}
