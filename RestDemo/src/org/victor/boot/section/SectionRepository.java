package org.victor.boot.section;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "section", path = "section")
public interface SectionRepository extends PagingAndSortingRepository<Section, Long> {
	List<Section> findByName(/*@Param("name") */String name);
}
