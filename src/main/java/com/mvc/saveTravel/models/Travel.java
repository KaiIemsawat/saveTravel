package com.mvc.saveTravel.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Travel")
public class Travel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="This field can't be empty")
	@Size(min = 3, max = 150, message="Please input a short message")
	private String expense;
	
	@NotEmpty(message="This field can't be empty")
	@Size(min = 3, max = 150, message="Please input a short message")
	private String vendor;
	
	@NotNull(message="This field can't be empty")
	@Min(value=1, message="The price is too low")
	private Double amount;
	
	@NotNull(message="Description must not be blank")
	@Size(min = 5, max = 400, message="please input proper description")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updaeAt;
	
	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updaeAt = new Date();
	}
	
	
//	Constructors
	public Travel() {}


	public Travel(
			String expense,
			String vendor,
			Double amount,
			String description
			) {
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	
	
	
//	Getter and Setter
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdaeAt() {
		return updaeAt;
	}
	public void setUpdaeAt(Date updaeAt) {
		this.updaeAt = updaeAt;
	}
	
	
	
	
}
