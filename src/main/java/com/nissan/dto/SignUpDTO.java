package com.nissan.dto;

public class SignUpDTO {

	//declare variables
	private String emailId;
	private String password;
	private Integer typeId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String address;
	private Integer phoneNumber;
	
	//default constructor
	public SignUpDTO() {

	}

	//parameterized constructor
	public SignUpDTO(String emailId, String password, Integer typeId, String firstName, String lastName, Integer age,
			String gender, String address, Integer phoneNumber) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.typeId = typeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	//getters and setters
	public String getEmailId() {
		return emailId;
	}

	public void setUsername(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//toString()
	@Override
	public String toString() {
		return "SignUpDTO [emailId=" + emailId + ", password=" + password + ", typeId=" + typeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
}
