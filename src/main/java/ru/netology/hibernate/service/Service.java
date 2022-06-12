package ru.netology.hibernate.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.Repository;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public List<Person> getPersonByCity(String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    public List<Person> findAllByPersonId_AgeLessThanOrderByPersonId(int age) {
        return repository.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }

    Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(String name, String surname) {
        return repository.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }



}
