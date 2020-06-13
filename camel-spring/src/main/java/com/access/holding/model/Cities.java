package com.access.holding.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cities")
public class Cities implements Serializable{
	
	@XmlElement(name = "city")
    protected List<City> cities = new ArrayList<City>();
	public List<City> getCities() {
		return cities;
	}

}
