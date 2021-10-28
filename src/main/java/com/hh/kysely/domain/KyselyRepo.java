package com.hh.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KyselyRepo extends CrudRepository<Kysely, Long>
{

    List<Kysely> findByTitle(String title);
    
}