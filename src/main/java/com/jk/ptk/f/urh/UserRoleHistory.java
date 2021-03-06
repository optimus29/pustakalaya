package com.jk.ptk.f.urh;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.jk.ptk.f.user.User;
import com.jk.ptk.f.user.UserRole;

/**
 * Represents an entry of user's role history.
 *
 * @author Jitendra
 */
@Entity
@NamedQuery(name = "urh_find_all_by_email", query = "SELECT urh FROM UserRoleHistory urh INNER JOIN urh.user u WHERE u.email=:email")
public class UserRoleHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userFk", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleFk", nullable = false)
	private UserRole role;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "assignedByFk", nullable = false)
	private User assignedBy;

	@JoinColumn(name = "assignDate", nullable = false)
	private LocalDateTime assignDate;

	private String comments;

	public UserRoleHistory() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public User getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(User assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getAssignDate() {
		return assignDate;
	}

}
