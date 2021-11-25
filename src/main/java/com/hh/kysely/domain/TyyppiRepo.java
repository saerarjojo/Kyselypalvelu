package com.hh.kysely.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TyyppiRepo extends JpaRepository<Tyyppi, Long> {

}
