package org.victor.boot.topics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {

	@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
	public Page<Topic> findBySection(@Param("section") String section, Pageable p);

}
