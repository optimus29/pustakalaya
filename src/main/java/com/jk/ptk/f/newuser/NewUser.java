package com.jk.ptk.f.newuser;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jk.ptk.f.user.User;
import com.jk.ptk.f.user.UserRole;

/**
 * Represents a new user added with partial details.
 *
 * @author Jitendra
 */
@Entity
@NamedQueries({ @NamedQuery(name = "newUser_delete_by_email", query = "delete from NewUser u where u.email=:email"),
		@NamedQuery(name = "newUser_find_by_email", query = "select u from NewUser u where u.email=:email") })
public class NewUser {
	@Id
	private String id;

	@Column(name = "emailUk", nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(name = "locale", nullable = false)
	private String localeStr;

	@Column(nullable = false)
	@JsonIgnore
	private LocalDateTime createdOn;

	@Column(nullable = false)
	@JsonIgnore
	private LocalDateTime expiresOn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleFk", nullable = false)
	@JsonIgnore
	private UserRole role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "acCreatedByFk", nullable = false)
	@JsonIgnore
	private User acCreatedBy;

	/**
	 * Default constructor.
	 */
	public NewUser() {
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@JsonProperty("locale")
	public String getLocaleStr() {
		return localeStr;
	}

	@JsonProperty("locale")
	public void setLocaleStr(String localeStr) {
		this.localeStr = localeStr;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(LocalDateTime expiresOn) {
		this.expiresOn = expiresOn;
	}

	public User getAcCreatedBy() {
		return acCreatedBy;
	}

	public void setAcCreatedBy(User acCreatedBy) {
		this.acCreatedBy = acCreatedBy;
	}

}
