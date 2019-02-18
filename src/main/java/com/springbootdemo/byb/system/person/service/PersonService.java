package com.springbootdemo.byb.system.person.service;

import com.springbootdemo.byb.system.person.model.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    List<Person> getAll();
    Person selectByPrimaryKey(Integer id);

}
