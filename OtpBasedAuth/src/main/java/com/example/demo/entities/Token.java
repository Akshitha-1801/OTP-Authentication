package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	@Column
	String otp;
	@Column
	LocalDateTime createdAt;
	public Token(int id, User user, String otp, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.otp = otp;
		this.createdAt = createdAt;
	}
	public Token(User user, String otp, LocalDateTime createdAt) {
		super();
		this.user = user;
		this.otp = otp;
		this.createdAt = createdAt;
	}
	public Token() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
}
