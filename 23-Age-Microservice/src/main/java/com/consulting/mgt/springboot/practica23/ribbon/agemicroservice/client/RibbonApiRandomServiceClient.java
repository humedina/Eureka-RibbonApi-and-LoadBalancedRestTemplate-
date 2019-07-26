package com.consulting.mgt.springboot.practica23.ribbon.agemicroservice.client;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("ribbon-api")
public class RibbonApiRandomServiceClient implements IRamdomService {

	private RestTemplate simpleRestTemplate = new RestTemplate();

	@Autowired
	private LoadBalancerClient loadBalancedClient;

	@Value("${random-service-name:random-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public int getRandomValue() {

		ServiceInstance instance = loadBalancedClient.choose(serviceName);
		// build URI using service-name
		URI uri = new URI(String.format("http://%s:%s/random-service/next", instance.getHost(), instance.getPort()));
		log.info("URI: {}", uri);
		// getting map from loadBalanced RestTemplate
		Map<String, Object> mapResponse = simpleRestTemplate.getForObject(uri, Map.class);

		log.info("[ApiRibbon] {} response: {}", serviceName, mapResponse);

		return (int) mapResponse.get("random");
	}

}
