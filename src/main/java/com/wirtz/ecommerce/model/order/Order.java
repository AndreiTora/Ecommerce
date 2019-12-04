package com.wirtz.ecommerce.model.order;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.orderline.Orderline;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
@Table(name="TheOrder")
public class Order {
	
	@Column(name="idOrder")
	   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOrder;

	@ManyToOne
	@JoinColumn(name="userProfileId")
	private UserProfile userOrder;
	private Date date;
	
	@OneToMany(mappedBy="order")
	private Set<Orderline> orderlines = new HashSet<Orderline>();
	
	private long version;
	
	public Order(UserProfile userOrder, Date date, Set<Orderline> orderlines, long version) {
		super();
		this.userOrder = userOrder;
		this.date = date;
		this.orderlines = orderlines;
		this.version = version;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}

	public UserProfile getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserProfile userOrder) {
		this.userOrder = userOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(Set<Orderline> orderlines) {
		this.orderlines = orderlines;
	}
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
}
