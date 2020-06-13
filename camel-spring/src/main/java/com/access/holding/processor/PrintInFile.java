package com.access.holding.processor;
import java.io.File;
import java.nio.file.FileSystems;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;

import com.access.holding.model.Cities;
import com.access.holding.model.City;

public class PrintInFile {

	@Handler
	public void print(Exchange exchange,CamelContext context) throws Exception {
		
	    final String output = FileSystems.getDefault().getPath("").toAbsolutePath()+"/src/main/resources/output/";

		City city = exchange.getIn().getBody(City.class);
		JAXBContext jaxbContext = JAXBContext.newInstance(Cities.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		String countryName = city.getCountry();
		boolean fileCreated = false;
		Cities cities = null;
		File file = new File(output+countryName+".xml");
		if (!file.exists()) {
			fileCreated =  file.createNewFile();
		} 
		// Read XML
		if (!fileCreated) {
			cities = (Cities) unmarshaller.unmarshal(file);
		}else {
			cities = new Cities();
		}

		cities.getCities().add(city);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(cities, file);
	}

}
