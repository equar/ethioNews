package com.ethionews.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "record")
public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String link;
	private String description;
	private String content;
	private Date date;
	private String imageURL;
	private Media media;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 1000, nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = true)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "link", nullable = false)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "content", nullable = true)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "imageURL", nullable = true)
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "mediaId", nullable = true)
	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

}
