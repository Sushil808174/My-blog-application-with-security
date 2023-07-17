package com.skumar.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;

	private String content;

	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "postId")
	private Posts post;

}
