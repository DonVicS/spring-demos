package org.victor.boot.comments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

	@RestResource(path = "commentByTopicId", rel = "commentByTopicId")
	public Page<Comment> findByTopicId(@Param("topicId") Long topicId, Pageable p);

	@RestResource(path = "commentByUserId", rel = "commentByUserId")
	public Page<Comment> findByUserId(@Param("userId") Long userId, Pageable p);
}
