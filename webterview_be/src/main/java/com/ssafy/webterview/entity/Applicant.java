package com.ssafy.webterview.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Applicant")
@Data
@DynamicInsert
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Applicant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ApplicantNo", nullable = false)
	private Integer applicantNo;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "RoomNo")
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "GroupNo")
	private Group group;

	@Column(name = "ApplicantName", nullable = false, length = 45)
	private String applicantName;

	@Column(name = "ApplicantEmail", nullable = false, length = 45)
	private String applicantEmail;

	@Column(name = "ApplicantAge")
	private Integer applicantAge;

	@Column(name = "ApplicantUniv", length = 45)
	private String applicantUniv;

	@Column(name = "ApplicantGPA")
	private Double applicantGPA;

	@Column(name = "ApplicantLicense", length = 100)
	private String applicantLicense;

	@Column(name = "ApplicantLang", length = 100)
	private String applicantLang;

	@Column(name = "ApplicantDate")
	private Instant applicantDate;

	@Column(name = "ApplicantPhone", nullable = false, length = 15)
	private String applicantPhone;

	@OneToMany(mappedBy = "applicant")
	private List<Resume> resumes = new ArrayList<>();

	@Column(name = "ApplicantFile")
	private String applicantFile;
}