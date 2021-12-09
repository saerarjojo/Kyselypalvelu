package com.hh.kysely.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Tyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tyyppi_id;
	private String tyyppi;
		
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "tyyppi")
	@JsonIgnoreProperties ("tyyppi")
	private List<Kysymys> kysymyksia;
	
	public Tyyppi() {}

	public Tyyppi(String tyyppi) {
		super();
		this.tyyppi = tyyppi;
	}

	public Long getTyyppi_id() {
		return tyyppi_id;
	}

	public void setTyyppi_id(Long tyyppi_id) {
		this.tyyppi_id = tyyppi_id;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}



	public List<Kysymys> getKysymyksia() {
		return kysymyksia;
	}

	public void setKysymyksia(List<Kysymys> kysymyksia) {
		this.kysymyksia = kysymyksia;
	}

	@Override
	public String toString() {
			return "Tyyppi [tyyppi_id=" + tyyppi_id + ", tyyppi=" + tyyppi + "]";
	}
	
	
	

	
}
