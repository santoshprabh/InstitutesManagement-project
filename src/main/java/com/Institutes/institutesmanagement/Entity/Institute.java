 package com.Institutes.institutesmanagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="institutes")
public class Institute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	private String location;
	
	private String contact;
	
	private String courses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public Institute(Long id, String name, String location, String contact, String courses) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Institute [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact
				+ ", courses=" + courses + "]";
	}

	public Institute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
