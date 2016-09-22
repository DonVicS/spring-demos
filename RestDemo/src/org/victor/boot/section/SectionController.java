package org.victor.boot.section;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/section", headers= "Accept=application/json")
public class SectionController {

	@Autowired
	private SectionRepository repository;

	public SectionController() {
	}

	@RequestMapping(value = "{sectionName}", method = RequestMethod.GET)
	public HttpEntity<Section> showByName(@PathVariable("sectionName") String sectionName) {
		sectionName = sectionName.toLowerCase();
		Section section = repository.findByName(sectionName).get(0);
		section.add(linkTo(methodOn(SectionController.class).showByName(sectionName)).withSelfRel());
		return new ResponseEntity<Section>(section, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<List<Section>> showAll() {
		List<Section> sections = (List<Section>) repository.findAll();
		for (Section section : sections){
			section.add(linkTo(methodOn(SectionController.class).showByName(section.getName())).withSelfRel());
		}
		return new ResponseEntity<List<Section>>(sections, HttpStatus.OK);
	}

	//TODO POST
	public void create() {

	}

	//TODO PUT
	public void update() {

	}

	//TODO DELETE
	public void delete() {

	}

}
