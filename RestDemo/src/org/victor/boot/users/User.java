package org.victor.boot.users;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.hateoas.ResourceSupport;
import org.victor.boot.utils.Role;

@Entity
public class User extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = -8976041506051060183L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private Role role;
	private String userName;
	private String name;
	private String surname;
	private String age;
	@CreatedDate
	private final LocalDateTime created;

	public User() {
		created = LocalDateTime.now();
		role = Role.USER;
	}

	// @JsonCreator
	public User(/* @JsonProperty("user") */User user) {
		this.userId = user.userId;
		this.role = (user.role == null) ? Role.USER : user.role;
		this.userName = user.userName;
		this.name = user.name;
		this.surname = user.surname;
		this.age = user.age;
		this.created = (user.created == null) ? LocalDateTime.now() : user.created;
	}

	public User(Long userId, Role role, String userName, String name, String surname, String age,
			LocalDateTime created) {
		this.userId = userId;
		this.role = (role == null) ? Role.USER : role;
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.created = (created == null) ? LocalDateTime.now() : created;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return String.format("User [userId=%s, role=%s, userName=%s, name=%s, surname=%s, age=%s, created=%s]", userId,
				role, userName, name, surname, age, created);
	}

}