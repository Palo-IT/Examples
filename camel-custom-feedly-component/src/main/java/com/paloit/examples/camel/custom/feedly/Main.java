package com.paloit.examples.camel.custom.feedly;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		
		logger.info("Starting Custom Apache Camel component example");
		logger.info("Press CTRL+C to terminate the JVM");
		
		org.apache.camel.main.Main main = new org.apache.camel.main.Main();
		main.enableHangupSupport();
		
		main.addRouteBuilder(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				PropertiesComponent properties = new PropertiesComponent();
				properties.setLocation("classpath:feedly.properties");
				getContext().addComponent("properties", properties);
				
		    	from("feedly://search/feeds?delay={{delay}}&query={{query}}")
		    	
		    	.split(body())
		    	
				.log(body().toString());
			}
		});
		
		main.run();
	}
}