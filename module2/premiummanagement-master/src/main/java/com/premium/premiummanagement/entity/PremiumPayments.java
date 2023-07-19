package com.premium.premiummanagement.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PremiumPayments")
public class PremiumPayments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PaymentDate")
	private LocalDate paymentDate = LocalDate.now();
	
	@Column(name="BankTransactionId",length=30)
	private String bankTransactionId;
	
	@Column(name="PremiumAmount",length=10)
	private float premiumAmount;
	
	@Column(name="LateFee",length=10)
	private float lateFee;
	
	@Column(name="PaymentMethodId",length=10)
	private int paymentMethodId;
	
	@Column(name="PremiumMasterId",length=10)
	private int premiumMasterId;	

	public PremiumPayments() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PremiumPayments(int id, LocalDate paymentDate, String bankTransactionId, float premiumAmount, float lateFee,
			int paymentMethodId, int premiumMasterId) {
		super();
		this.id = id;
		this.paymentDate = paymentDate;
		this.bankTransactionId = bankTransactionId;
		this.premiumAmount = premiumAmount;
		this.lateFee = lateFee;
		this.paymentMethodId = paymentMethodId;
		this.premiumMasterId = premiumMasterId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public float getLateFee() {
		return lateFee;
	}

	public void setLateFee(float lateFee) {
		this.lateFee = lateFee;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public int getPremiumMasterId() {
		return premiumMasterId;
	}

	public void setPremiumMasterId(int premiumMasterId) {
		this.premiumMasterId = premiumMasterId;
	}
}
