package com.example.springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getPerson(){
        System.out.println(personRepository.findAll());
        return personRepository.findAll();
    }

    @GetMapping("/personsCustom")
    public List<Person> getPersonCust(){
        System.out.println(personRepository.findCustomAll());
        return personRepository.findCustomAll();
    }


    @GetMapping("/personById/{id}")
    public Person getPersonById(@PathVariable String id){
        System.out.println(personRepository.findById(id));
        return personRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable String id){
        System.out.println(">>>>>"+personRepository.deleteById(id));
        return personRepository.deleteById(id);
    }

}
