package com.ita.covid.ProjectCovid19;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
    @Query(value="SELECT * FROM Person p WHERE p.person_state = ?1",nativeQuery = true)
    List<Person> findByState(String state);
    @Query(value="SELECT * FROM Person p WHERE p.person_city = ?1",nativeQuery = true)
    List<Person> findByCity(String city);
    @Query(value="SELECT * FROM Person p WHERE p.person_infection_date LIKE ?1",nativeQuery = true)
    List<Person> findByDate(String q);

}
