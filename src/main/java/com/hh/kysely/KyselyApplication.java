package com.hh.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hh.kysely.domain.*;

@SpringBootApplication
public class KyselyApplication {
	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselyDemo(KyselyRepo kRepo, KysymysRepo kysymRepo, VastausRepo vRepo, TyyppiRepo trepo)
	{
		return (args) -> {
			log.info("save a couple of question");
			
			Kysely kysely1 = new Kysely ("Värit");
			kRepo.save(kysely1);
			
			Tyyppi tyyppi1 = new Tyyppi ("Normaali");
			trepo.save(tyyppi1);
			
			Tyyppi tyyppi2 = new Tyyppi ("Monivalinta");
			trepo.save(tyyppi2);
			
			Kysymys kysymys1 = new Kysymys ("Minkä värinen on musta?", kysely1);
			kysymRepo.save(kysymys1);
			
			Kysymys kysymys2 = new Kysymys ("Minkä värinen on sininen?", kysely1);
			kysymRepo.save(kysymys2);
			
			Kysymys kysymys3 = new Kysymys ("Mikä on lempivärisi?", kysely1);
			kysymRepo.save(kysymys3);
			
			Kysymys kysymys4 = new Kysymys ("Mikä on jouluinen väri?", kysely1);
			kysymRepo.save(kysymys4);
			
			Kysymys kysymys5 = new Kysymys ("Mitkä ovat päävärit?", kysely1);
			kysymRepo.save(kysymys5);
			
			Vastaus vastaus1 = new Vastaus ("musta", kysymys1);
			vRepo.save(vastaus1);
					
			log.info("fetch all");
			for (Kysely kysely : kRepo.findAll())
			{
				log.info(kysely.toString());
			}
			
			for (Tyyppi tyyppi : trepo.findAll())
			{
				log.info(tyyppi.toString());
			}
			
			
			for (Kysymys kysymys : kysymRepo.findAll())
			{
				log.info(kysymys.toString());
			}
			
			for (Vastaus vastaus : vRepo.findAll())
			{
				log.info(vastaus.toString());
			}
			
		};
	}
}
