package org.victor.boot.topics;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.hateoas.ResourceSupport;

@Entity
public class Topic extends ResourceSupport implements Serializable {
	
	private static final long serialVersionUID = 3872067131182321702L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long topicId;
	private String section;
	private String title;
	private String introduction;
	private String content;
	@CreatedDate
	private final LocalDateTime created;

	public Topic() {
		created = LocalDateTime.now();
	}

	public Topic(Topic topic) {
		this.topicId = topic.topicId;
		this.section = topic.section;
		this.title = topic.title;
		this.introduction = topic.introduction;
		this.content = topic.content;
		this.created = (topic.created == null) ? LocalDateTime.now() : topic.created;
	}

	public Topic(Long topicId, String section, String title, String introduction, String content, LocalDateTime created) {
		this.topicId = topicId;
		this.section = section;
		this.title = title;
		this.introduction = introduction;
		this.content = content;
		this.created = (created == null) ? LocalDateTime.now() : created;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return String.format("Topic [topicId=%s, title=%s, introduction=%s, content=%s, created=%s]", topicId, title,
				introduction, content, created);
	}
	
}
