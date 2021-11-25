package com.hh.kysely.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyselyRepo extends JpaRepository<Kysely, Long>
{

    List<Kysely> findByTitle(String title);
    
}