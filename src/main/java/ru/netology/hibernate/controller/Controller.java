package ru.netology.hibernate.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.service.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/persons")
@RestController
public class Controller {
    Service service;

    @GetMapping("/by-city")
    public List<Person> getPersonByCity(String city) {
        return service.getPersonByCity(city);
    }


    @GetMapping("/by-age")
    public List<Person> findAllByPersonId_AgeLessThanOrderByPersonId(int age) {
        return service.findAllByPersonId_AgeLessThanOrderByPersonId(age);
    }

    @GetMapping("by-name-and-surname")
    public Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(String name, String surname) {
        return service.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }
}
