package com.cg.bookauthor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AuthorTable")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;

	/*
	 * @Temporal(TemporalType.DATE) //required for Date and Calendar Types
	 * 
	 * @Column(name = "order_date") private Date purchaseDate;
	 */

	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "bookauthortable", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	private Set<Book> products = new HashSet<>(); // required to avoid
													// NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public Date getPurchaseDate() {
	// return purchaseDate;

	// public void setPurchaseDate(Date purchaseDate) {
	// this.purchaseDate = purchaseDate;

	public Set<Book> getProducts() {
		return products;
	}

	public void setProducts(Set<Book> products) {
		this.products = products;
	}

	public void addProduct(Book product) {
		this.getProducts().add(product);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
