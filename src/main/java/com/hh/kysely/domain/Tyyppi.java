package com.hh.kysely.domain;

import javax.persistence.*;

@Entity
public class Tyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tyyppi_id;
	private String tyyppi;
		
	@OneToOne
	@MapsId
	@JoinColumn (name = "kysymysid")
	private Kysymys kysymys;
	
	public Tyyppi() {}

	public Tyyppi(String tyyppi, Kysymys kysymys) {
		super();
		this.tyyppi = tyyppi;
		this.kysymys = kysymys; 
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

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		if (this.kysymys!= null)
			return "Tyyppi [tyyppi_id=" + tyyppi_id + ", tyyppi=" + tyyppi + ", kysymys=" + this.getKysymys() + "]";
		else
			return "Tyyppi [tyyppi_id=" + tyyppi_id + ", tyyppi=" + tyyppi + "]";
	}
	
	
	

	
}
