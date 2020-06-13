package com.access.holding.route;

import java.nio.file.FileSystems;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

import com.access.holding.processor.PrintInFile;
import com.access.holding.processor.SplitFileData;

public class Csv2XmlRouteBuilder implements RoutesBuilder {

   public void addRoutesToCamelContext(CamelContext context) throws Exception {
	   
	 
      final String input = FileSystems.getDefault().getPath("").toAbsolutePath()+"/src/main/resources/input";
	   
	   RouteBuilder splitter = new RouteBuilder() {

			public void configure() {		 
				from("file:"+input).
				unmarshal().
				csv().
				split(method(new SplitFileData())).
				to("direct:csv2xml");
			}
		};
       
		RouteBuilder printer =  new RouteBuilder() {
			public void configure() {	
				from("direct:csv2xml").
				bean(new PrintInFile());
			}
		};
		context.addRoutes(splitter);
		context.addRoutes(printer);

	}

}