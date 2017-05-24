package com.springbase.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "user_role")
public class UserRole implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
	private User user;

	@NotNull
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private UserRoleType role;

	public User getUser() {
		return user;
	}

	public UserRoleType getRole() {
		return role;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRole(UserRoleType role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role.name();
	}

}
