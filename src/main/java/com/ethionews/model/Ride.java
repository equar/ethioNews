package com.ethionews.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ride")
public class Ride implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String from;
	private String to;
	private String date;
	private String time;
	private String phonenumber;
	private String description;
	private User user;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "fromLocation", nullable = false)
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "toLocation", nullable = false)
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "date", nullable = false)
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "time", nullable = false)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "phonenumber", nullable = false)
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
