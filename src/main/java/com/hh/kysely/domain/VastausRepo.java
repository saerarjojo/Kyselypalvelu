package com.hh.kysely.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VastausRepo extends CrudRepository<Vastaus, Long>
	{

	    List<Vastaus> findByVastaus(String vastaus);
	    
	}

