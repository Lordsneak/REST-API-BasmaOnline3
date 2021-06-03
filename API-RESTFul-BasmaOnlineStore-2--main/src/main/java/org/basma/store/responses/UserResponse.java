package org.basma.store.responses;

public class UserResponse {
	
	private String userId;
	private String nomUser;
	private String prenomUser;
	private String email;	
	private Boolean userValid;
	private String roleUser;
 
	 
 

	public Boolean getUserValid() {
		return userValid;
	}


	public void setUserValid(Boolean userValid) {
		this.userValid = userValid;
	}


	public String getRoleUser() {
		return roleUser;
	}


	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}


	public String getNomUser() {
		return nomUser;
	}


	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}


	public String getPrenomUser() {
		return prenomUser;
	}


	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

	

}
