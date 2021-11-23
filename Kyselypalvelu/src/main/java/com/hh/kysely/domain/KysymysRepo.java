package com.hh.kysely.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KysymysRepo extends JpaRepository<Kysymys, Long>
	{	
	List<Kysely> findByKysymys(String kysymys);
	}


