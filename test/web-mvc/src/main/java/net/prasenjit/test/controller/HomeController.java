package net.prasenjit.test.controller;

import java.util.List;

import net.prasenjit.test.beans.MyComponent;
import net.prasenjit.test.controller.io.PersonForm;
import net.prasenjit.test.entity.Address;
import net.prasenjit.test.entity.Person;
import net.prasenjit.test.repo.jpa.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private MyComponent comp;

	@Autowired
	private PersonRepository personRepo;

	@ResponseBody
	@RequestMapping("/index")
	public List<Person> index() {
		List<Person> persons = personRepo.findAll();
		return persons;
	}

	@ResponseBody
	@RequestMapping(value = "/new", method = RequestMethod.POST, consumes = "application/json")
	public PersonForm newPerson(@RequestBody PersonForm person) {
		Person p = new Person(person.getName());
		p.setAddress(new Address());
		p.getAddress().setStreet(person.getAddress());
		personRepo.save(p);
		return person;
	}

	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deletePerson(@PathVariable Long id) {
		personRepo.delete(id);
		return "success";
	}
}
