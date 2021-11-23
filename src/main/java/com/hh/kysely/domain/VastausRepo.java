package com.hh.kysely.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VastausRepo extends JpaRepository<Vastaus, Long>
	{

	    List<Vastaus> findByVastaus(String vastaus);
	    
	}

