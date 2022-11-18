package com.example.bean;

import com.example.util.FileUpload;

import java.util.Date;

public class MemberVO {
	private int seq;
	private String sid;
    private String position;
	private String name;
    private int age;
	private String major;
    private String phone;
	private Date regdate;
    private String photo;
	
	public int getSeq() {
        return seq;
	}
	public void setSeq(int seq) {
        this.seq = seq;
	}
	public String getSid() {
        return sid;
	}
	public void setSid(String sid) {
        this.sid = sid;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
	public String getName() {
        return name;
	}
	public void setName(String name) {
        this.name = name;
	}
	public int getAge() {
        return age;
	}
	public void setAge(int age) {
        this.age = age;
	}
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
	public Date getRegdate() {
        return regdate;
	}
	public void setRegdate(Date regdate) {
        this.regdate = regdate;
	}
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
