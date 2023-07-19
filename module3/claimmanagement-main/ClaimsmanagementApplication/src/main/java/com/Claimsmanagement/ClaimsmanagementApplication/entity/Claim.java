package com.Claimsmanagement.ClaimsmanagementApplication.entity;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="claims")
public class Claim {



		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
		@NonNull
		@Column(name="PolicyId",length=10)
		private int policyId;
		@NonNull
		@Column(name="UserName",length=10)
		private String userName;
		@NonNull
		@Column(name="SubscriptionId",length=10)
		private int subscriptionId;
		@NonNull
		@Column(name="ClaimDate",columnDefinition = "DATE")
		private LocalDate claimDate = LocalDate.now();
		@Column(name="ClaimTypeId",length=10)
		private int claimTypeId;
		 @NonNull
		@Column(name="ClaimSummary",length=100)
		private String claimSummary;
		 @NonNull
		 @Column(name="ClaimDetails",length=500)
		private String claimDetails;
		 @NonNull
		@Pattern(regexp="New|Approved|Rejected")
		@Column(name="ClaimStatus",length=12)
		private String claimStatus;
		@NonNull
		@Column(name="IsRaisedByPolicyHolder")
		private Boolean isRaisedByPolicyHolder;
		@NonNull
		@JoinColumn(name="ClaimantFullName")
		@Size(min=1,max=50)
		private String claimantFullName;
		 @NonNull
		@JoinColumn(name="ClaimantDateOfBirth")
		private Date claimantDateOfBirth;
		 @NonNull
		@JoinColumn(name="ClaimantAddress")
		 @Size(min=1,max=100)
		private String claimantAddress;
		 @NonNull
		@Pattern(regexp="Passport|Aadhar|PAN|DrivingLicense")
		@JoinColumn(name="ClaimantIDProofType")
		 @Size(min=1,max=20)
		private String claimantIDProofType;
		 @NonNull
		@JoinColumn(name="ClaimantIDProofNumber")
		 @Size(min=1,max=20)
		private String claimantIDProofNumber;
		 @NonNull
		@Future
		@JoinColumn(name="ResponseETA")
		private LocalDate responseETA;
		 
		public Claim(){
			
			 super();

		}
		public Claim(int id,int policyId,String userName, int subscriptionId,LocalDate claimDate,int claimTypeId,String claimSummary,
				String claimDetails,String claimStatus,Boolean isRaisedByPolicyHolder,String claimantFullName,Date claimantDateOfBirth,
				String claimantAddress,String claimantIDProofType,String claimantIDProofNumber,LocalDate responseETA){
			
			 super();
			 this.id = id;
			 this.policyId = policyId;
			 this.userName = userName;
			 this.subscriptionId = subscriptionId;
			 this.claimDate = claimDate;
			 this.claimTypeId = claimTypeId;
			 this.claimSummary = claimSummary;
			 this.claimDetails = claimDetails;
			 this.claimStatus = claimStatus;
			 this.isRaisedByPolicyHolder = isRaisedByPolicyHolder;
			 this.claimantFullName = claimantFullName;
			 this.claimantDateOfBirth = claimantDateOfBirth;
			 this.claimantAddress = claimantAddress;
			 this.claimantIDProofType = claimantIDProofType;
			 this.claimantIDProofNumber = claimantIDProofNumber;
			 this.responseETA = responseETA;
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
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getSubscriptionId() {
			return subscriptionId;
		}
		public void setSubscriptionId(int subscriptionId) {
			this.subscriptionId = subscriptionId;
		}
		public LocalDate getClaimDate() {
			return claimDate;
		}
		public void setClaimDate(LocalDate claimDate) {
			this.claimDate = claimDate;
		}
		public int getClaimTypeId() {
			return claimTypeId;
		}
		public void setClaimTypeId(int claimTypeId) {
			this.claimTypeId = claimTypeId;
		}
		public String getClaimSummary() {
			return claimSummary;
		}
		public void setClaimSummary(String claimSummary) {
			this.claimSummary = claimSummary;
		}
		public String getClaimDetails() {
			return claimDetails;
		}
		public void setClaimDetails(String claimDetails) {
			this.claimDetails = claimDetails;
		}
		public String getClaimStatus() {
			return claimStatus;
		}
		public void setClaimStatus(String claimStatus) {
			this.claimStatus = claimStatus;
		}
		public Boolean getIsRaisedByPolicyHolder() {
			return isRaisedByPolicyHolder;
		}
		public void setIsRaisedByPolicyHolder(Boolean isRaisedByPolicyHolder) {
			this.isRaisedByPolicyHolder = isRaisedByPolicyHolder;
		}
		public String getClaimantFullName() {
			return claimantFullName;
		}
		public void setClaimantFullName(String claimantFullName) {
			this.claimantFullName = claimantFullName;
		}
		public Date getClaimantDateOfBirth() {
			return claimantDateOfBirth;
		}
		public void setClaimantDateOfBirth(Date claimantDateOfBirth) {
			this.claimantDateOfBirth = claimantDateOfBirth;
		}
		public String getClaimantAddress() {
			return claimantAddress;
		}
		public void setClaimantAddress(String claimantAddress) {
			this.claimantAddress = claimantAddress;
		}
		public String getClaimantIDProofType() {
			return claimantIDProofType;
		}
		public void setClaimantIDProofType(String claimantIDProofType) {
			this.claimantIDProofType = claimantIDProofType;
		}
		public String getClaimantIDProofNumber() {
			return claimantIDProofNumber;
		}
		public void setClaimantIDProofNumber(String claimantIDProofNumber) {
			this.claimantIDProofNumber = claimantIDProofNumber;
		}
		public LocalDate getResponseETA() {
			return responseETA;
		}
		public void setResponseETA(LocalDate responseETA) {
			this.responseETA = responseETA;
		}

}
