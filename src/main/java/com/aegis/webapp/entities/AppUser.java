package com.aegis.webapp.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "app_user")
public class AppUser {
	 
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	private Long userId;
	
	@Column(name = "user_name")
	@NotEmpty(message = "Provide user name")
    private String userName;
    private String encrytedPassword;
    
    @Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
    private String email;
    
    @Column(name = "enabled")
    private boolean enabled;
    
	@Column(name = "confirmation_token")
	private String confirmationToken;
    
	@Column(name = "balance")
	private Integer balance;
	
    public AppUser() {
 
    }
    

	public AppUser(Long userId, String userName, String encrytedPassword, String email, String confirmationToken,boolean enabled,Integer balance) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.email = email;
		this.confirmationToken = confirmationToken;
		this.enabled = enabled;
		this.balance = balance;
	}




	public Long getUserId() {
        return userId;
    }
 

	public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getEncrytedPassword() {
        return encrytedPassword;
    }
 
    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getConfirmationToken() {
		return confirmationToken;
	}


	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	
	public boolean isEnabled() {
			return enabled;
	}

	public void setEnabled(boolean enabled) {
			this.enabled = enabled;
	}
	
	
	public Integer getBalance() {
		return balance;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	@Override
    public String toString() {
        return this.userName + "/" + this.encrytedPassword;
    }
 
}
