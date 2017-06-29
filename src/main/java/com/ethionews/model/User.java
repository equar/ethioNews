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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String username;
	private String password;
	private String passwordConfirm;
	private boolean enabled;
	private Set<UserRole> userRoles = new HashSet<>();
	private Set<Video> videos = new HashSet<>();
	private Set<Event> events = new HashSet<>();
	private Set<Job> jobs = new HashSet<>();
	private Set<Rent> rents = new HashSet<>();
	private Set<Ride> rides = new HashSet<>();
	private Set<Speak> speaks = new HashSet<>();
	private Set<Profession> professions = new HashSet<>();

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "UserAndRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Rent> getRents() {
		return rents;
	}

	public void setRents(Set<Rent> rents) {
		this.rents = rents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Ride> getRides() {
		return rides;
	}

	public void setRides(Set<Ride> rides) {
		this.rides = rides;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Speak> getSpeaks() {
		return speaks;
	}

	public void setSpeaks(Set<Speak> speaks) {
		this.speaks = speaks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Profession> getProfessions() {
		return professions;
	}

	public void setProfessions(Set<Profession> professions) {
		this.professions = professions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}

}
