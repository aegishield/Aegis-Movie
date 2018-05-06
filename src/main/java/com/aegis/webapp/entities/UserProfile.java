package com.aegis.webapp.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="user_profile")
public class UserProfile {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "profileid")
	private Long profileId;
	
	@Column(name = "userid")
	private Long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "telp")
	private String telp;
	
	

	
	
	public UserProfile() {
		super();
	}

	public UserProfile(Long profileId, Long userId, String name, String address, String telp) {
		super();
		this.profileId = profileId;
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.telp = telp;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}
	
}
