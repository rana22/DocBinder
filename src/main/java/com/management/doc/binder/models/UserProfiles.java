package com.management.doc.binder.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class UserProfiles implements Serializable{
	
	 /**
	 * Ambar Rana user_prorfile entity store all the user info
	 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	 	@Column(name="id")
	    private Long id;
	 	
	 	@Column(name="first_name")
	    private String firstName;
	 	
	 	@Column(name="last_name")
	    private String lastName;
	 	
	 	@NotNull
	 	@Column(name="user_name")
	 	private String userName;
	 	
	 	@Column(name="password")
	 	private String password;
	 	
	 	@Column(name="email")
	 	private String email;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		

}
