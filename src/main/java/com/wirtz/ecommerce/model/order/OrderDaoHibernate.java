package com.wirtz.ecommerce.model.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;

@Repository
public class OrderDaoHibernate extends GenericDaoHibernate<Order, Long> implements OrderDao {



}
