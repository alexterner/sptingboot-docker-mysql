package com.company.springboot.docker.mysql.dal.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sites")
public class Site implements Serializable
{

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private Boolean isActive;

	public Site()
	{

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	@Column(name = "name")
	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@Column(name = "is_active")
	public Boolean getIsActive()
	{
		return isActive;
	}

	public void setIsActive( Boolean isActive )
	{
		this.isActive = isActive;
	}


}
