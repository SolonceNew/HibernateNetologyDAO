package ru.netology.hibernate.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.Repository;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    Repository repository;

    public List<Person> getPersonByCity(String city) {
        return repository.getPersonByCity(city);
    }

}
