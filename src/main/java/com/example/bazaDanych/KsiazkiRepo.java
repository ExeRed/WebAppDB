package com.example.bazaDanych;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface KsiazkiRepo extends JpaRepository <Ksiazka, Integer> {
    List<Ksiazka> findAllByNazwa(String wyszukaj);

}
