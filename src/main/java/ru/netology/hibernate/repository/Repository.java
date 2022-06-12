package ru.netology.hibernate.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, PersonId> {

    List<Person> findPersonByCityOfLiving(String city);

    List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_Age(int age);


    Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(String name, String surname);
}
