package org.victor.boot.comments;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(headers = "accept=application/json")
public class CommentController {

	@Autowired
	private CommentRepository repository;

	public CommentController() {
	}

	@RequestMapping(value = "section/{sectionName}/topics/{topicId}/comments/{commentId}", method = RequestMethod.GET)
	public HttpEntity<Comment> show(@PathVariable("sectionName") String sectionName,
			@PathVariable("topicId") Long topicId, @PathVariable("commentId") Long commentId) {
		Comment comment = repository.findOne(commentId);
		comment.add(linkTo(methodOn(CommentController.class).show(sectionName, topicId, commentId)).withSelfRel());
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "section/{sectionName}/topics/{topicId}/comments", method = RequestMethod.GET)
	public HttpEntity<PagedResources<Comment>> showAllCommentsInTopic(@PathVariable("sectionName") String sectionName,
			@PathVariable("topicId") Long topicId, Pageable pageable, PagedResourcesAssembler assembler) {
		Page<Comment> comments = (Page<Comment>) repository.findByTopicId(topicId, pageable);
		for (Comment comment : comments) {
			comment.add(linkTo(methodOn(CommentController.class).show(sectionName, topicId, comment.getCommentId()))
					.withSelfRel());
		}
		return new ResponseEntity<>(assembler.toResource(comments), HttpStatus.OK);
	}

	@RequestMapping(value = "users/{userId}/comments/{commentId}", method = RequestMethod.GET)
	public HttpEntity<Comment> showOneCommentByUserId(@PathVariable("userId") Long userId,
			@PathVariable("commentId") Long commentId) {
		Comment comment = repository.findOne(commentId);
		comment.add(linkTo(methodOn(CommentController.class).showOneCommentByUserId(userId, commentId)).withSelfRel());
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "users/{userId}/comments", method = RequestMethod.GET)
	public HttpEntity<PagedResources<Comment>> showAllCommentsByUserId(@PathVariable("userId") Long userId, Pageable pageable, PagedResourcesAssembler assembler) {
		Page<Comment> comments = (Page<Comment>) repository.findByUserId(userId, pageable);
		for (Comment comment : comments) {
			comment.add(linkTo(methodOn(CommentController.class).showOneCommentByUserId(userId, comment.getCommentId()))
					.withSelfRel());
		}
		return new ResponseEntity<>(assembler.toResource(comments), HttpStatus.OK);
	}
	
	//TODO POST
	
	//TODO PUT
	
	//TODO DELETE

}
