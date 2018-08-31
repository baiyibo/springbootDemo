package com.springbootdemo.byb;

import com.springbootdemo.byb.person.model.Person;
import com.springbootdemo.byb.person.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PersonService personService;
	@Test
	public void contextLoads() {
		Person person =new Person();
		person.setName("byb");
		person.setAge(23);
		personService.addPerson(person);
		List<Person> people=personService.getAll();
		for (Person person1:people) {
			System.out.println(person1.getName()+"================="+person1.getAge());
		}
	}

}
