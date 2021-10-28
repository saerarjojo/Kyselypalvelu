package com.hh.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hh.kysely.domain.*;

@SpringBootApplication
public class KyselyApplication 
{
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepo kRepo)
	{
		return (args) -> 
		{
			log.info("save a couple of question");
			
			kRepo.save(new Kysely("Kysymys 1", "Kysymys???"));
			kRepo.save(new Kysely("Kysymys 2", "Kysymys???"));	
			
			log.info("fetch all questions");
			for (Kysely kysely : kRepo.findAll())
			{
				log.info(kysely.toString());
			}
		};
	}
}
