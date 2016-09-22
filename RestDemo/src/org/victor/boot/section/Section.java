package org.victor.boot.section;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;

@Entity
public class Section extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 2673682335180714506L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sectionId;
	private String name;

	public Section() {
	}

	public Section(Section section) {
		this.sectionId = section.sectionId;
		this.name = section.name;
	}

	public Section(Long sectionId, String name) {
		this.sectionId = sectionId;
		this.name = name;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Section [sectionId=%s, name=%s]", sectionId, name);
	}

}
