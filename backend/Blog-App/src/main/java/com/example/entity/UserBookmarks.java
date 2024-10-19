package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblUserBookMark")
public class UserBookmarks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookmarkId;

	@Email
	@Column(length = 100, nullable = false)
	private String userEmail;

	@NotBlank
	@Column(nullable = false)
	private int postId;

	@Override
	public String toString() {
		return "UserBookmarks [bookmarkId=" + bookmarkId + ", userEmail=" + userEmail + ", postId=" + postId;
		// ", bookmarkStatus=" + bookmarkStatus + "]";
	}

}
