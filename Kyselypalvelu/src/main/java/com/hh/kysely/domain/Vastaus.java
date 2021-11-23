package com.hh.kysely.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Vastaus {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long vastausid;
	 private String vastaus;
	    
	 	@ManyToOne
	 	@JsonIgnoreProperties("vastaukset")
	    @JoinColumn (name = "kysymysid")
	    private Kysymys kysymys;
	
	
	    	public Vastaus () {}
		    
		    public Vastaus(String vastaus, Kysymys kysymys) {
				super();
				this.vastaus = vastaus;
				this.kysymys = kysymys;
			}

			public Long getVastausid() {
				return vastausid;
			}

			public void setVastausid(Long vastausid) {
				this.vastausid = vastausid;
			}

			public String getVastaus() {
				return vastaus;
			}

			public void setVastaus(String vastaus) {
				this.vastaus = vastaus;
			}

			public Kysymys getKysymys() {
				return kysymys;
			}

			public void setKysymys(Kysymys kysymys) {
				this.kysymys = kysymys;
			}
		    
		    
			@Override
			public String toString() {
				if (this.kysymys != null)
					return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + ", kysymys=" + this.getKysymys() + "]";
				else
					return "Vastaus [vastausid=" + vastausid + ", vastaus=" + vastaus + "]";	
			}
}
