package com.cg.moviesforyou.MovieBookSpringBoot.dto;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "admin")
public class Admin {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer adminId;
	
	@Column(name = "username")
	@Pattern(regexp = "^[^\\d\\s]+$", message = "Should not have spaces and digits")
	private String adminName;
	
	@Column(name = "password")
	@Size(min = 8, message = "Passwould length should be greater than or equal to 8 characters")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})", message = "Password must have an uppercase, a lower case, a number and a special character")
	private String adminPassword;
	
	@Column(name = "phone_number")
	@Size(min = 10, max = 10, message = "phone number should be 10 digits")
	private String contactNumber;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId, String adminName, String adminPassword, String contactNumber) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.contactNumber = contactNumber;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", contactNumber=" + contactNumber + "]";
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
