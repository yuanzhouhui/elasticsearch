package com.peach.elasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {
	@Bean
	RestHighLevelClient elasticsearchClient() {
		ClientConfiguration configuration = ClientConfiguration.builder()
				.connectedTo("10.0.0.211:9200")
				//.withConnectTimeout(Duration.ofSeconds(5))
				//.withSocketTimeout(Duration.ofSeconds(3))
				//.useSsl()
				//.withDefaultHeaders(defaultHeaders)
				//.withBasicAuth(username, password)
				// ... other options
				.build();
		RestHighLevelClient client = RestClients.create(configuration).rest();
		return client;
	}
}
