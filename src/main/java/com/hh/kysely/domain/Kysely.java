package com.hh.kysely.domain;

import javax.persistence.*;

@Entity
public class Kysely
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String question;
    
    public Kysely() {}

	public Kysely(String title, String question) 
	{
		super();
		this.title = title;
		this.question = question;	
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

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}
	

	@Override
	public String toString()
	{
			return "Kysely [id=" + id + ", title=" + title + ", question=" + question + "]";
	}
}
