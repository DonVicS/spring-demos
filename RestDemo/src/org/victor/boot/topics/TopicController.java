package org.victor.boot.topics;

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
@RequestMapping(value = "section/{sectionName}/topics", headers = "accept=application/json")
public class TopicController {

	@Autowired
	private TopicRepository repository;

	public TopicController() {
	}

	@RequestMapping(value = "{topicId}", method = RequestMethod.GET)
	public HttpEntity<Topic> show(@PathVariable("sectionName") String sectionName,
			@PathVariable("topicId") Long topicId) {
		Topic topic = repository.findOne(topicId);
		topic.add(linkTo(methodOn(TopicController.class).show(sectionName, topicId)).withSelfRel());
		return new ResponseEntity<Topic>(topic, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<PagedResources<Topic>> showAll(@PathVariable("sectionName") String sectionName, Pageable pageable,
			PagedResourcesAssembler assembler) {
		Page<Topic> topics = (Page<Topic>) repository.findBySection(sectionName, pageable);
		for (Topic topic : topics) {
			topic.add(linkTo(methodOn(TopicController.class).show(sectionName, topic.getTopicId())).withSelfRel());
		}
		return new ResponseEntity<>(assembler.toResource(topics), HttpStatus.OK);
	}

	//TODO POST
	
	//TODO PUT
	
	//TODO DELETE

}
