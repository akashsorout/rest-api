package in.co.bytehub.restapi.app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@ElementCollection
	private List<Chapter> chapters;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Teacher> teachers;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Topic(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Topic(String name) {
		this.name=name;
	}
	public Topic() {

	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public Topic setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
		return this;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public Topic setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
		return this;
	}
}
