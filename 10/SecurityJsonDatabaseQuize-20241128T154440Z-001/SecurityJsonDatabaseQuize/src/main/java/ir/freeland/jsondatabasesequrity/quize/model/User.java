package ir.freeland.jsondatabasesequrity.quize.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	private int userId;
	private String firstName;
	private String  lastName;
    private String email;
    private String password;
    private LocalDate dateOfBirth;
    @JsonProperty("is_active")
    private boolean isActive;
    private List<String> roles;
    private String profilePictureUrl;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", dateOfBirth=" + dateOfBirth + ", isActive="
				+ isActive + ", roles=" + roles + ", profilePictureUrl="
				+ profilePictureUrl + ", address=" + address + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
    
}
