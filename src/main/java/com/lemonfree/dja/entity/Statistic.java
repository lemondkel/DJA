package com.lemonfree.dja.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "DJA_TB_STA")
public class Statistic {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private Date createdDate;

	@Column
	private String title;

	@Column
	private int correctCount;

	@ManyToOne
	@JoinColumn(name = "user_id",
			referencedColumnName = "id")
	private User user;
}
