package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblComment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	@NotEmpty
	@Column(length = 1000)
	private String content;

	@Email
	@Column(length = 200)
	private String userEmail;

	@Column
	private int postId;


	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content + ", userEmail=" + userEmail + ", postId="
				+ postId + "]";
	}

}
