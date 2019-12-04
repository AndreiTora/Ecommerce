package com.wirtz.ecommerce.model.userprofile;
import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.orderline.Orderline;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UserProfile {

	private Long userProfileId;
	
	
	@NotBlank(groups= {LoginUserGroupValidator.class})
	@Size(min = 4, max=8)
	private String loginName;
	private String encryptedPassword;
	
	//Added ++19
	@NotBlank(groups= {RegisterUserGroupValidator.class, LoginUserGroupValidator.class})
	@Size(min = 4, groups= {RegisterUserGroupValidator.class})	
	private String password;
	

	@NotBlank(groups= {RegisterUserGroupValidator.class})
	@Size(min = 4, groups= {RegisterUserGroupValidator.class})
	//Added ++19
	private String passwordConfirm;
	@NotBlank
	@Size(min = 1)
	private String firstName;
	@NotBlank
	@Size(min = 1)
	private String lastName;
	@Email
	private String email;
    private long version;
    
    @OneToMany(mappedBy="user")
    private Set<Cartline> carlines = new HashSet<Cartline>();
    
    @OneToMany
    @JoinColumn(name="userOrder")
    private Set<Orderline> orderlines = new HashSet<Orderline>();
	
	public UserProfile() {
	}

	public UserProfile( String loginName, String encryptedPassword,
			String firstName, String lastName, String email) {
		/**
		 * NOTE: "userProfileId" *must* be left as "null" since its value is
		 * automatically generated.
		 */
		
		this.loginName = loginName;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Column(name="usrId")
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name="enPassword")
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	
    @Transient
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	@Override
	public int hashCode() {
		return loginName == null ? 0 : loginName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserProfile))
			return false;
		final UserProfile other = (UserProfile) obj;
		if (email == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!email.equals(other.getEmail()))
			return false;
		if (encryptedPassword == null) {
			if (other.getEncryptedPassword() != null)
				return false;
		} else if (!encryptedPassword.equals(other.getEncryptedPassword()))
			return false;
		if (firstName == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!firstName.equals(other.getFirstName()))
			return false;
		if (lastName == null) {
			if (other.getLastName() != null)
				return false;
		} else if (!lastName.equals(other.getLastName()))
			return false;
		if (loginName == null) {
			if (other.getLoginName() != null)
				return false;
		} else if (!loginName.equals(other.getLoginName()))
			return false;
		if (userProfileId == null) {
			if (other.getUserProfileId() != null)
				return false;
		} else if (!userProfileId.equals(other.getUserProfileId()))
			return false;
		if (version != other.getVersion())
			return false;
		return true;
	}
}