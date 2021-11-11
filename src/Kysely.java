package com.hh.kysely.domain;

import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kyselyid;
    private String title;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
    @JsonIgnoreProperties("kysely")
    private List<Kysymys> kysymykset;
  
    
    public Kysely() {}

	public Kysely(String title) {
		super();
		this.title = title;
	}

	public Long getKyselyid() {
		return kyselyid;
	}

	public void setKyselyid(Long kyselyid) {
		this.kyselyid = kyselyid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString()
	{
		
		return "Kysely [kyselyid=" + kyselyid + ", title=" + title + "]";
	}
}
