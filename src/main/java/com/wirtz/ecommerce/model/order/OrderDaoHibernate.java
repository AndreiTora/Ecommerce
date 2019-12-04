package com.wirtz.ecommerce.model.order;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;

@Repository
public class OrderDaoHibernate extends GenericDaoHibernate<Order, Long> implements OrderDao{

}
