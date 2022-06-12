package ru.netology.hibernate.repository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, PersonId> {

    @Query("select p from Person p where p.cityOfLiving = :cityOfLiving")
    List<Person> findPersonByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.personId.age < :age order by p.personId.age asc")
    List<Person> findAllByPersonId_AgeLessThanOrderByPersonId_Age(@Param("age") int age);

    @Query("select p from Person p where p.personId.name = :name and p.personId.surname = :surname")
    Optional<Person> findPersonByPersonId_NameAndPersonId_Surname(@Param("name") String name,
                                                                  @Param("surname") String surname);
}
