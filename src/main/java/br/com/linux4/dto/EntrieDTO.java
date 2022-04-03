package br.com.linux4.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntrieDTO {
	private String API;
	private String Description;
	private String Auth;
	private String Cors;
	private String Link;
	private String Category;
	private Boolean HTTPS;

	public String getAPI() {
		return API;
	}

	public void setAPI(String aPI) {
		API = aPI;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getAuth() {
		return Auth;
	}

	public void setAuth(String auth) {
		Auth = auth;
	}

	public String getCors() {
		return Cors;
	}

	public void setCors(String cors) {
		Cors = cors;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public Boolean getHTTPS() {
		return HTTPS;
	}

	public void setHTTPS(Boolean hTTPS) {
		HTTPS = hTTPS;
	}
}
