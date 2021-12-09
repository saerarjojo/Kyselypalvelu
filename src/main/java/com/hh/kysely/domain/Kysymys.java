package com.hh.kysely.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kysymys {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long kysymysid;
	 private String kysymys;
	    
	 
	 	@ManyToOne
	 	@JsonIgnoreProperties ("kysymykset")
	    @JoinColumn (name= "kyselyid")
	    private Kysely kysely;
		
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	    @JsonIgnoreProperties ("kysymys")
	    private List<Vastaus> vastaukset;
	    
	    @ManyToOne
	    @JsonIgnoreProperties ("kysymyksia")
	    @JoinColumn (name = "tyyppi_id")
	    private Tyyppi tyyppi;
	    
	    public Kysymys () {}

		public Kysymys(String kysymys, Kysely kysely) {
			super();
			this.kysymys = kysymys;
			this.kysely = kysely;
		}

		public Long getKysymysid() {
			return kysymysid;
		}

		public void setKysymysid(Long kysymysid) {
			this.kysymysid = kysymysid;
		}

		public String getKysymys() {
			return kysymys;
		}

		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}

		public Kysely getKysely() {
			return kysely;
		}

		public void setKysely(Kysely kysely) {
			this.kysely = kysely;
		}

		
		public List<Vastaus> getVastaukset() {
			return vastaukset;
		}

		public void setVastaukset(List<Vastaus> vastaukset) {
			this.vastaukset = vastaukset;
		}
		
		
		public Tyyppi getTyyppi() {
			return tyyppi;
		}

		public void setTyyppi(Tyyppi tyyppi) {
			this.tyyppi = tyyppi;
		}

		@Override
		public String toString() {
			if (this.kysely != null)
				return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + ", kysely=" + this.getKysely() + "]";
			else 
				return "Kysymys [kysymysid=" + kysymysid + ", kysymys=" + kysymys + "]";
		}
}
