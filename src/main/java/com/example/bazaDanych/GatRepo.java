package com.example.bazaDanych;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatRepo extends JpaRepository <Gatunek1, Integer>{

}