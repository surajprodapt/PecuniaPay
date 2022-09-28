package com.pecuniaPay.registrationLogin.security.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

//  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  
  @NotBlank
  private String firstName;
  
  @NotBlank
  private String lastName;
  
  @NotBlank
  private String mobileNumber;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public String getMobileNumber() {
	return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
  }
  
  

//  public Set<String> getRole() {
//    return this.role;
//  }
//
//  public void setRole(Set<String> role) {
//    this.role = role;
//  }
}
