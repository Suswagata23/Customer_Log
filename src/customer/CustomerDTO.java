package com.suswagata.Customer_Log.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="customer_log")
public class CustomerDTO {
	
	@Id
	@Column(name="ID")
	private String Id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOGTYPE")
	private String logType;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="TIME")
	private String time;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public CustomerDTO(String id, String name, String logType, String date, String time) {
		super();
		Id = id;
		this.name = name;
		this.logType = logType;
		this.date = date;
		this.time = time;
	}	
	
	public CustomerDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerDTO [Id=" + Id + ", name=" + name + ", logType=" + logType + ", date=" + date + ", time=" + time
				+ "]";
	}

	public void setId(String name, String time) {
		Id = name+time;
	}

}
