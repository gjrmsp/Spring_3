package com.google.s3.account;

import java.sql.Date;

public class AccountDTO {
	
	private String accountnumber;
	private long accountbalance;
	private Date accountdate;
	private String id;
	private long booknumber;
	
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public long getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(long accountbalance) {
		this.accountbalance = accountbalance;
	}
	public Date getAccountdate() {
		return accountdate;
	}
	public void setAccountdate(Date accountdate) {
		this.accountdate = accountdate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(long booknumber) {
		this.booknumber = booknumber;
	}
	
}
