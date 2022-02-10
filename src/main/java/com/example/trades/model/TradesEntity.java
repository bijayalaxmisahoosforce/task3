package com.example.trades.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="trades")
public class TradesEntity {

	private Long id;
	private String price;
	private String qty;
	private String quoteQty;
	private Date time;
	private Boolean isBuyerMaker;
	private Boolean isBestMatch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsBuyerMaker() {
		return isBuyerMaker;
	}

	public void setIsBuyerMaker(Boolean isBuyerMaker) {
		this.isBuyerMaker = isBuyerMaker;
	}

	public Boolean getIsBestMatch() {
		return isBestMatch;
	}

	public void setIsBestMatch(Boolean isBestMatch) {
		this.isBestMatch = isBestMatch;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQuoteQty() {
		return quoteQty;
	}

	public void setQuoteQty(String quoteQty) {
		this.quoteQty = quoteQty;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
