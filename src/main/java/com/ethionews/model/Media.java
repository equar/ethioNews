package com.ethionews.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String url;
	private String type;
	private String language;
	private String country;
	private boolean crawel;
	private Set<Record> record = new HashSet<>();
	private Set<Subscription> subscription = new HashSet<>();

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "language", nullable = false)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "crawel", nullable = false)
	public boolean isCrawel() {
		return crawel;
	}

	public void setCrawel(boolean crawel) {
		this.crawel = crawel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "media")
	public Set<Record> getRecord() {
		return record;
	}

	public void setRecord(Set<Record> record) {
		this.record = record;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "media", cascade = CascadeType.ALL)
	public Set<Subscription> getSubscription() {
		return subscription;
	}

	public void setSubscription(Set<Subscription> subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", language=" + language
				+ ", country=" + country + ", crawel=" + crawel + ", record=" + record + ", subscription="
				+ subscription + "]";
	}
	
	

}
