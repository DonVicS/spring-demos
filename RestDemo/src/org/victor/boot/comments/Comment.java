package org.victor.boot.comments;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.hateoas.ResourceSupport;

@Entity
public class Comment extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = -896424762362869496L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commentId;
	private long userId;
	private long topicId;
	private String content;
	@CreatedDate
	private final LocalDateTime created;

	public Comment() {
		created = LocalDateTime.now();
	}

	public Comment(Comment comment) {
		this.commentId = comment.commentId;
		this.userId = comment.userId;
		this.topicId = comment.topicId;
		this.content = comment.content;
		this.created = (comment.created == null) ? LocalDateTime.now() : comment.created;
	}

	public Comment(long commentId, long userId, long topicId, String content, LocalDateTime created) {
		this.commentId = commentId;
		this.userId = userId;
		this.topicId = topicId;
		this.content = content;
		this.created = (created == null) ? LocalDateTime.now() : created;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	@Override
	public String toString() {
		return String.format("Comment [commentId=%s, userId=%s, topic=%s, content=%s, created=%s]", commentId, userId,
				topicId, content, created);
	}

}
