package org.ajb.services.rest;

import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CrudPOJO {

	@Id
	private String token;
	private String tokenData;

	public CrudPOJO(String token, String tokenData) {
		super();
		this.token = token;
		this.tokenData = tokenData;
	}

	public CrudPOJO() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenData() {
		return tokenData;
	}

	public void setTokenData(String tokenData) {
		this.tokenData = tokenData;
	}

}
