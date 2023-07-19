package com.Claimsmanagement.ClaimsmanagementApplication.entity;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="claimresponse")
public class ClaimResponse {
		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
		@NonNull
		@Column(name="ResponseDate",columnDefinition = "DATE")
		private LocalDate responseDate;
		@NonNull
		@Column(name="ResponseDetails",length=500)
		private String responseDetails;
		@NonNull
		@Column(name="ClaimId",length=10)
		private int claimId;
		
		public ClaimResponse() {
			super();
			
		}
		public ClaimResponse( int id, LocalDate responseDate,String responseDetails,int claimId) {
			super();
			this.id = id;
			this.responseDate = responseDate;
			this.responseDetails = responseDetails;
			this.claimId = claimId;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public LocalDate getResponseDate() {
			return responseDate;
		}

		public void setResponseDate(LocalDate responseDate) {
			this.responseDate = responseDate;
		}

		public String getResponseDetails() {
			return responseDetails;
		}

		public void setResponseDetails(String responseDetails) {
			this.responseDetails = responseDetails;
		}

		public int getClaimId() {
			return claimId;
		}

		public void setClaimId(int claimId) {
			this.claimId = claimId;
		}
}
