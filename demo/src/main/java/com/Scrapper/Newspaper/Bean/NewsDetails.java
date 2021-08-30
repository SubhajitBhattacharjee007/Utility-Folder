package com.Scrapper.Newspaper.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NewsDetails {
	
	@Id
	@GeneratedValue
	int id;
	String url;
	String date;
	String organization;
	
	public NewsDetails() {
	}

	public NewsDetails(int id, String url, String date, String organization) {
		this.id = id;
		this.url = url;
		this.date = date;
		this.organization = organization;
	}

	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	
}
