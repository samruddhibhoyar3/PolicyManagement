package com.premium.premiummanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PremiumsMaster")
public class PremiumsMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="PolicyId",length=10)
	private int policyId;
	
	@Column(name="Username",length=10)
	@Pattern(regexp="\\w{10}",message="Username should be 10 characters long")
	private String Username;
	
	@Column(name="SubscriptionId",length=10)
	private int subscriptionId;
	
	//@Temporal(TemporalType.DATE)
    @Future(message = "Start date must be in the future")
	@Column(name="PremiumStartDate")
	private Date premiumStartDate;
	
	@Column(name="PremiumAmount",length=10)
	private float premiumAmount;
	
	@Column(name="TotalNumberOfPremiums",length=10)
	private int totalNumberOfPremiums;
	
	@Column(name="CurrentPolicyStatus",length=20)
	@Pattern(regexp = "^(Ongoing|Matured|Defaulted|Cancelled)$", message = "Invalid current policy status")
	// ^ show start of input string $ show end of input string | separate input string
	private String currentPolicyStatus;
	
	@Column(name="LastPaymentDate")
	private Date lastPaymentDate;
	
	
	

	public PremiumsMaster(int id, int policyId,
			@Pattern(regexp = "\\w{10}", message = "Username should be 10 characters long") String username,
			int subscriptionId, @Future(message = "Start date must be in the future") Date premiumStartDate,
			float premiumAmount, int totalNumberOfPremiums, String currentPolicyStatus, Date lastPaymentDate) {
		super();
		this.id = id;
		this.policyId = policyId;
		Username = username;
		this.subscriptionId = subscriptionId;
		this.premiumStartDate = premiumStartDate;
		this.premiumAmount = premiumAmount;
		this.totalNumberOfPremiums = totalNumberOfPremiums;
		this.currentPolicyStatus = currentPolicyStatus;
		this.lastPaymentDate = lastPaymentDate;
	}
	

	public PremiumsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Date getPremiumStartDate() {
		return premiumStartDate;
	}

	public void setPremiumStartDate(Date premiumStartDate) {
		this.premiumStartDate = premiumStartDate;
	}

	public float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public int getTotalNumberOfPremiums() {
		return totalNumberOfPremiums;
	}

	public void setTotalNumberOfPremiums(int totalNumberOfPremiums) {
		this.totalNumberOfPremiums = totalNumberOfPremiums;
	}

	public String getCurrentPolicyStatus() {
		return currentPolicyStatus;
	}

	public void setCurrentPolicyStatus(String currentPolicyStatus) {
		this.currentPolicyStatus = currentPolicyStatus;
	}

	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	
	
}
