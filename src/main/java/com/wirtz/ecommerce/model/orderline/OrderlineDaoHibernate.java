package com.wirtz.ecommerce.model.orderline;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;

@Repository
public class OrderlineDaoHibernate extends GenericDaoHibernate<Orderline, Long>implements OrderlineDao {

}
