package com.springbootdemo.byb.person.service;

import com.springbootdemo.byb.person.model.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    List<Person> getAll();
    Person selectByPrimaryKey(Integer id);

}
