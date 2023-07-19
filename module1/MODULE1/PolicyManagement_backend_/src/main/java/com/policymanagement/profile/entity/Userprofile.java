package com.policymanagement.profile.entity;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
public class Userprofile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Userprofile() {
		super();
		
	}

	public Userprofile(Long id, @Size(min = 10, max = 10) String username, @Size(max = 20) String firstName,
			@Size(max = 20) String middleName, @Size(max = 20) String lastName, LocalDate dateOfBirth,
			@Pattern(regexp = "[MFO]") String gender, @Size(max = 20) String profession,
			@Size(max = 200) String currentAddress, @Size(max = 20) String nationality,
			@Pattern(regexp = "Passport|Aadhar|PAN|DrivingLicence") String idProof, @Size(max = 20) String docNumber,
			@Size(max = 100) String phoneNumber, @Size(max = 16) String emailAddress) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.profession = profession;
		this.currentAddress = currentAddress;
		this.nationality = nationality;
		this.idProof = idProof;
		this.docNumber = docNumber;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		} else {
			this.firstName = ""; // Set a default value or handle the null case according to your logic
		}
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "username", length = 10, nullable = false, unique = true)
	@Size(min = 10, max = 10)
	private String username;

	@Column(name = "FirstName", length = 20)
	@Size(max = 20)
	private String firstName;

	@Column(name = "MiddleName", length = 20)
	@Size(max = 20)
	private String middleName;

	@Column(name = "LastName", length = 20)
	@Size(max = 20)
	private String lastName;

	@Column(name = "DateOfBirth")
	private LocalDate dateOfBirth;

	@Column(name = "Gender", length = 1)
	@Pattern(regexp = "[MFO]")
	private String gender;

	@Column(name = "Profession", length = 20)
	@Size(max = 20)
	private String profession;

	@Column(name = "CurrentAddress", length = 200)
	@Size(max = 200)
	private String currentAddress;

	@Column(name = "Nationality", length = 20)
	@Size(max = 20)
	private String nationality;

	@Column(name = "IDProof", length = 20)
	@Pattern(regexp = "Passport|Aadhar|PAN|DrivingLicence")
	private String idProof;

	@Column(name = "DocNumber", length = 20)
	@Size(max = 20)
	private String docNumber;

	@Column(name = "PhoneNumber", length = 100)
	@Size(max = 100)
	private String phoneNumber;

	@Column(name = "EmailAddress", length = 16)
	@Size(max = 16)
	private String emailAddress;
}
