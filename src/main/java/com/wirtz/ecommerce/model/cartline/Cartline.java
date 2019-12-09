package com.wirtz.ecommerce.model.cartline;

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

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
public class Cartline {
	
	
	@Column(name="cartlineId")
	   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cartlineId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")
	private UserProfile user;
	
	

	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	private Long amount;
	
    private long version;
    
	public Cartline() {
		super();
	}
	
	public Cartline(UserProfile user, Product product, Long amount) {
		super();
		this.user = user;
		this.product = product;
		this.amount = amount;
	}	
	
	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Long getCartlineId() {
		return cartlineId;
	}
	public void setCartlineId(Long cartlineId) {
		this.cartlineId = cartlineId;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	

}
