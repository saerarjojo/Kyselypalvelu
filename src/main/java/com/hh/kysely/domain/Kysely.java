package com.hh.kysely.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Kysely
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String[] questions;
    private String squestions = "";
    
    public Kysely() {}

	public Kysely(String title, String[] questions) 
	{
		super();
		this.title = title;
		this.questions = questions;	
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String[] getQuestions()
	{
		return questions;
	}

	public void setQuestions(String[] questions)
	{
		this.questions = questions;
	}
	

	@Override
	public String toString()
	{
		squestions = Arrays.toString(questions);
		return "Kysely [id=" + id + ", title=" + title + ", questions=" + squestions + "]";
	}
}
