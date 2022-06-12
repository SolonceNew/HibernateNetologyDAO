package ru.netology.hibernate.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.service.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
public class Controller {
    Service service;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonByCity(@RequestParam("city") String city) {
        return service.getPersonByCity(city);
    }


    @GetMapping("/persons/by-age")
    public List<Person> findAllByPersonId_AgeLessThanOrderByPersonId(@RequestParam("age") int age) {
        return service.findAllByPersonId_AgeLessThanOrderByPersonId(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(@RequestParam("name") String name,
                                                                  @RequestParam("surname") String surname) {
        return service.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }
}
