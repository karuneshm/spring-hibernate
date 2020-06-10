package com.karunesh.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	
//	@OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
//	private Instructor instructor;
//	
	@OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.PERSIST})
	private Instructor instructor;
	
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [Id=" + Id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

	
	
	
	
	
	
	
	

}
