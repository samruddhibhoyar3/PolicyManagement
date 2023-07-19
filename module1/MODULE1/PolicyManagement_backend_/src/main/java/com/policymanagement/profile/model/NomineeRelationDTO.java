package com.policymanagement.profile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NomineeRelation")
public class NomineeRelationDTO {

	public NomineeRelationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NomineeRelationDTO(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type2) {
		this.type = type2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Type", nullable = false)
	private String type;
}
