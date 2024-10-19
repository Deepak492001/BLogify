package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblUsers")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Size(min = 4, message = "Username must be between greater than four characters")
	@Column(length = 60, nullable = false)
	@Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name format")
	private String name;

	@Email(message = "Invalid email address")
	@Column
	private String email;

	@NotBlank // check for null and empty
	@Size(min = 5, max = 14, message = "Password must be at between 4 and 14 characters")
	@Column(nullable = false)
	private String password;

	@NotBlank
	@Transient
	@Column(nullable = false)
	private String confirmPassowrd;

	@OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Post> posts = new HashSet<>();


	public User(String email) {
		// TODO Auto-generated constructor stub
		this.email = email;
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
