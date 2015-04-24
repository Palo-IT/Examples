package com.paloit.examples.camel.custom.feedly;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultPollingEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;

@UriEndpoint(scheme="feedly", title="Feedly", syntax="feedly://operationPath", consumerOnly=true, consumerClass=FeedlyConsumer.class, label="feeds")
public class FeedlyEndpoint extends DefaultPollingEndpoint {

	public FeedlyEndpoint(String uri, String operationPath, FeedlyComponent component) {
		super(uri, component);
		this.operationPath = operationPath;
	}
	
	private String operationPath;

	@UriParam
	private FeedlyConfiguration configuration;

	public Producer createProducer() throws Exception {
		throw new UnsupportedOperationException("FeedlyProducer is not implemented");
	}

	@Override
	public Consumer createConsumer(Processor processor) throws Exception {
		FeedlyConsumer consumer = new FeedlyConsumer(this, processor);
        return consumer;
	}

	public boolean isSingleton() {
		return true;
	}

	public String getOperationPath() {
		return operationPath;
	}

	public void setOperationPath(String operationPath) {
		this.operationPath = operationPath;
	}

	public FeedlyConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(FeedlyConfiguration configuration) {
		this.configuration = configuration;
	}
	
}