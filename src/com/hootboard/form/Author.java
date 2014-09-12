package com.hootboard.form;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
	@Id
	@GeneratedValue
	private int authorId;
	@Column
	private String authorName;
	@Column
	private String authorEmail;
	@Column
	private String authorLocation;
	
	@OneToMany(mappedBy="articleId")
	private Set<Article> articles;
	
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorLocation() {
		return authorLocation;
	}
	public void setAuthorLocation(String authorLocation) {
		this.authorLocation = authorLocation;
	}
	
}
