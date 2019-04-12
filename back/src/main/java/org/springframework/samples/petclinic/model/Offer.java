package org.springframework.samples.petclinic.model;

<<<<<<< HEAD
import java.sql.Date;
=======
import java.util.Date;
>>>>>>> fa5bec2bcbe771042e5f61992d848b9e1d02f5de

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
<<<<<<< HEAD
@Table(name = "Offers")
public class Offer extends BaseEntity{
	
	//private int id; lo hereda de BaseEntity
	@Column(name = "title")
	private String title;
	
	@Column(name = "descripion")
	private String description;
	
	@Column(name = "discount")
	private double discount;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "expire_data")
	private Date expireDate;
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
=======
@Table(name="offers")
public class Offer extends BaseEntity{
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="discount")
	private String discount;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="expireDate")
	private Date expireDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	
	
>>>>>>> fa5bec2bcbe771042e5f61992d848b9e1d02f5de

}
