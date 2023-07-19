package com.policymanagement.profile.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class UserprofileDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public UserprofileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserprofileDTO(Long id, String username, String firstName, String middleName, String lastName,
			LocalDate dateOfBirth, String gender, String profession, String currentAddress, String nationality,
			String idProof, String docNumber, String phoneNumber, String emailAddress) {
		super();
		this.id = id;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	@Column(name = "Username", length = 10, nullable = false, unique = true)
	@Size(min = 10, max = 10, message = "Username must be 10 characters")
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

	public String getFirstTwoLettersLowerCase() {
		if (firstName != null && firstName.length() >= 2) {
			return firstName.substring(0, 2).toLowerCase();
		} else {
			return ""; // Return an empty string or handle the null case according to your logic
		}
	}

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
