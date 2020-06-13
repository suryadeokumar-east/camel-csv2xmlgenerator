package com.access.holding.processor;
import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;

import com.access.holding.model.City;


public class SplitFileData {

	@Handler
	public List<City> process(Exchange exchange, CamelContext context) throws Exception{
		List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();
		List<City> cityList = new ArrayList<City>();
		for (List<String> line : data) {
			City city = new City();
			city.setName(line.get(1));
			city.setPopulation(line.get(2));
			city.setCountry(line.get(0));
			cityList.add(city);
		}
		return cityList;

	}

}
