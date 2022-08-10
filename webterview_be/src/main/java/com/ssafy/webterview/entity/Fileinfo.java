package com.ssafy.webterview.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@DynamicInsert
@Table(name = "Fileinfo")
public class Fileinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FileNo", nullable = false)
	private Integer fileNo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "ApplicantNo", nullable = false)
	private Applicant applicant;

	@Column(name = "SaveFolder", length = 45)
	private String saveFolder;

	@Column(name = "OriginFileName", length = 50)
	private String originFileName;

	@Column(name = "SaveFileName", length = 50)
	private String saveFileName;
}