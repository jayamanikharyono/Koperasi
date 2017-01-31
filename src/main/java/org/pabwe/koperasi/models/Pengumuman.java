package org.pabwe.koperasi.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pengumuman 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String content;
	private String objective;
	private String author;
	private Date dateIn;
	private Date dateExpired;
	
	public Pengumuman()
	{
		
	}
	
	public Pengumuman(int id, String title, String content, String objective, String author, Date dateIn,
			Date dateExpired) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.objective = objective;
		this.author = author;
		this.dateIn = dateIn;
		this.dateExpired = dateExpired;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public Date getDateExpired() {
		return dateExpired;
	}
	public void setDateExpired(Date dateExpired) {
		this.dateExpired = dateExpired;
	}
	
	
}
