package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="DhruvBootPractice")
public class UserFeedback {

	@Id
	private int id;
	@XmlElement
	private String week1;
	@XmlElement
	private String week2;
	@XmlElement
	private String week3;
	@XmlElement
	private String week4;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWeek1() {
		return week1;
	}
	public void setWeek1(String week1) {
		this.week1 = week1;
	}
	public String getWeek2() {
		return week2;
	}
	public void setWeek2(String week2) {
		this.week2 = week2;
	}
	public String getWeek3() {
		return week3;
	}
	public void setWeek3(String week3) {
		this.week3 = week3;
	}
	public String getWeek4() {
		return week4;
	}
	public void setWeek4(String week4) {
		this.week4 = week4;
	}
	@Override
	public String toString() {
		return "UserFeedback [week1=" + week1 + ", week2=" + week2 + ", week3=" + week3 + ", week4=" + week4 + "]";
	}
	
	
	
}
