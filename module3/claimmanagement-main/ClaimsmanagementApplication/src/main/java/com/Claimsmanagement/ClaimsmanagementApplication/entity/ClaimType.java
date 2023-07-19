package com.Claimsmanagement.ClaimsmanagementApplication.entity;

import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="claim_types")
public class ClaimType {
	
		
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int id;
		@NonNull
		@Column(name="Type",length=20)
		private String type;
		
		public ClaimType() {
			super();
			
		}
		public ClaimType(int id, String type) {
			super();
			this.id=id;
			this.type=type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id=id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type=type;
		}
		

}
