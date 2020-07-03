package com.ita.covid.ProjectCovid19;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelperRepository extends JpaRepository<Helper,String> {

    @Query(value="SELECT * FROM Helper p WHERE p.city = ?1",nativeQuery = true)
    List<Helper> findHelperByCity(String city);
}
