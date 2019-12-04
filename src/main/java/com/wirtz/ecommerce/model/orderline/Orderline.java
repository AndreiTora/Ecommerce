package com.wirtz.ecommerce.model.orderline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.order.Order;
import com.wirtz.ecommerce.model.product.Product;

@Entity
public class Orderline {

	@Column(name = "idOrderline")

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrderline;
	
	@ManyToOne
	@JoinColumn(name="idOrder")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private int amount;
	
	public Orderline(Product product, int amount, Order order, long version) {
		super();
		this.product = product;
		this.amount = amount;
		this.order = order;
		this.version = version;
	}
	
	public Long getIdOrderline() {
		return idOrderline;
	}

	public void setIdOrderline(Long idOrderline) {
		this.idOrderline = idOrderline;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	private long version;

	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
