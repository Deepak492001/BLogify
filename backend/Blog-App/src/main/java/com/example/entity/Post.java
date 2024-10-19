package com.example.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblPost")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@NotBlank
	@Column(nullable = false)
	private String postTitle;

	@NotBlank
	@Column(nullable = false, length = 65535)
	private String postContent;

	@NotBlank
	@Column(nullable = false)
	private String postLastmodified;

	@Column(nullable = false)
	@NotBlank
	private String postCategory;

	@Column(nullable = false)
	@NotBlank
	private String postUser;

	@NotEmpty
	@Lob
	@Column(length = 1048576, nullable = true)
	private byte[] postImage;

	// @ManyToOne
	// @JoinColumn(name = "category_Id")
	// private Category category;
	//
	// @ManyToOne
	// @JoinColumn(name = "user_Id")
	// private User user;

	public Post(String postTitle, String postContent, String postLastmodified, String postCategory, String postUser,
			byte[] postImage) {
		super();

		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postLastmodified = postLastmodified;
		this.postCategory = postCategory;
		this.postUser = postUser;
		this.postImage = postImage;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postLastmodified=" + postLastmodified + ", postCategory=" + postCategory + ", postUser=" + postUser
				+ ", postImage=" + Arrays.toString(postImage) + "]";
	}


}
