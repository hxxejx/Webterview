package com.ssafy.webterview.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@DynamicInsert
@Table(name = "room")
public class Room {
	@Id
	@Column(name = "RoomNo", nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "GroupNo", nullable = false)
	private Group groupNo;

	@Column(name = "RoomCode", length = 45)
	private String roomCode;

}