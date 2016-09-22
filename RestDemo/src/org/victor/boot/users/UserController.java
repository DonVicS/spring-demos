package org.victor.boot.users;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.victor.boot.exceptions.BadRequestException;
import org.victor.boot.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/users", headers = "Accept=application/json")
// @ExposesResourceFor(UserController.class)
// @EnableEntityLinks
public class UserController {

	@Autowired
	private UserRepository repository;

	 @Autowired EntityLinks entityLinks;
	
	public UserController() {

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public HttpEntity<User> showOne(@PathVariable("userId") Long userId) {
		User user = repository.findOne(userId);
		if (user == null)
			throw new ResourceNotFoundException();
		user.add(linkTo(methodOn(UserController.class).showOne(user.getUserId())).withSelfRel());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<PagedResources<User>> showAll(Pageable pageable, PagedResourcesAssembler assembler) {
		Page<User> users = repository.findAll(pageable);
		for (User user : users) {
			user.add(linkTo(methodOn(UserController.class).showOne(user.getUserId())).withSelfRel());
		}
		return new ResponseEntity<>(assembler.toResource(users), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody User user) {
		Optional.of(user).filter(u -> u.getUserId() == null/* && u.getRole() == null*/)
				.orElseThrow(BadRequestException::new);
		repository.save(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("userId") Long userId, @RequestBody User user) {
		user.setUserId(userId);
		repository.save(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("userId") Long userId) {
		repository.delete(userId);
	}

}
