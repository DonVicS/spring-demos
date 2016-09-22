package org.victor.boot.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	List<User> findBySurname(String surname);

	@RestResource
	Page<User> findAll(Pageable p);

}
