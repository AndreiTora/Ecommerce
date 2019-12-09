package com.wirtz.ecommerce.model.cartline;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Repository
public class CartlineDaoHibernate extends GenericDaoHibernate<Cartline, Long>implements CartlineDao {
	

	@Override
	public List<Cartline> findCartlinesByUserId(Long id) {
		
		String QueryFrom = "FROM Cartline WHERE user = " + id;
		List<Cartline> cartlines = getSession().createQuery(QueryFrom).list();
	
		return cartlines;
	}

	@Override
	public void insert(Long productId, Long userId) {
		
		String QueryInsert = "INSERT into Cartline (amount, version, productId, userProfileId) values (1, 1, " + productId + ", " + userId + ")";
		getSession().createNativeQuery(QueryInsert).executeUpdate();
	}

	@Override
	public void update(Long cartlineId, Long userId, Long amount) throws InstanceNotFoundException {

		Cartline cartline = find(cartlineId);
		Long cantidadActualizada = cartline.getAmount() + amount;
		
		String QueryUpdate = "UPDATE Cartline SET amount = "+ cantidadActualizada +" WHERE productId = " + cartlineId;
		getSession().createNativeQuery(QueryUpdate).executeUpdate();
	}
	
	
}
