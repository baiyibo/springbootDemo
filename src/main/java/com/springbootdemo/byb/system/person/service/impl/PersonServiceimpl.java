package com.springbootdemo.byb.system.person.service.impl;

import com.springbootdemo.byb.system.person.mapper.PersonMapper;
import com.springbootdemo.byb.system.person.model.Person;
import com.springbootdemo.byb.system.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceimpl implements PersonService {
    @Autowired
    private PersonMapper personMapper;
    @Override
    public void addPerson(Person person) {
        personMapper.insert(person);
    }

    @Override
    public List<Person> getAll() {
        return personMapper.selectAll();
    }

    @Override
    public Person selectByPrimaryKey(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }
}
