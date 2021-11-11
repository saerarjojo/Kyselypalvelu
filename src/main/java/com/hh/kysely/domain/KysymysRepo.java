package com.hh.kysely.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface KysymysRepo extends CrudRepository<Kysymys, Long>
	{

	    List<Kysymys> findByKysymys(String kysymys);
	    
	}


