package com.wirtz.ecommerce.model.cartservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.cartline.CartlineDao;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired 
	CartlineDao cartlineDao;
	
	public List<Cartline> findCartlinesByUserId(Long id) {

		return cartlineDao.findCartlinesByUserId(id);
	}
	
	public void delete(Long id) {
		
		try {
			cartlineDao.remove(id);
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Long productId, Long userId) {
		
		cartlineDao.insert(productId, userId);
	}
}
