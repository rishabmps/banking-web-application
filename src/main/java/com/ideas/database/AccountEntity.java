package com.ideas.database;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account")
@NamedQueries({ @NamedQuery (name="findByName",query="select a from AccountEntity a"
		+ " where a.name=:paraName")})
public class AccountEntity {
	private int id;
	private String name;
	private Date birtDate;
	private String type;
	private String mobile;
	private String pan_no;
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//@Transient
	@Column(name="account_name")
	public String getName() {
		return name;
	}

	public void setName(String name2) {
		this.name = name2;
	}
	
	@Column(name="birthdate")	
	@Temporal(TemporalType.DATE)
	public Date getBirtDate() {
		return birtDate;
	}
	
	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}

	//@Transient
	@Column(name="account_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	//@Transient
	@Column(name="mobile_no")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	//@Transient
	@Column(name="pan_card")
	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

}
