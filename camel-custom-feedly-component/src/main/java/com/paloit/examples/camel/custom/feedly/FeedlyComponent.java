package com.paloit.examples.camel.custom.feedly;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.UriEndpointComponent;

public class FeedlyComponent extends UriEndpointComponent {

	public FeedlyComponent() {
		super(FeedlyEndpoint.class);
	}

	@Override
	protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
		
		FeedlyEndpoint endpoint = new FeedlyEndpoint(uri, remaining, this);		
		FeedlyConfiguration configuration = new FeedlyConfiguration();
		
		// use the built-in setProperties method to clean the camel parameters map
		setProperties(configuration, parameters);
		
		endpoint.setConfiguration(configuration);		
		return endpoint;
	}
}