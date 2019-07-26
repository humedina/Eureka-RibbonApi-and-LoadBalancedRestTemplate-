package com.consulting.mgt.springboot.practica23.ribbon.agemicroservice.client;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("load-balanced-rest-template")
@Service
public class LoadBalancedRestTemplateRandomServiceClient implements IRamdomService {

	@Autowired
	private RestTemplate loadBalancedRestTemplate;

	@Value("${random-service-name:random-microservice}")
	private String serviceName;

	@Override
	@SneakyThrows
	public int getRandomValue() {

		URI uri = new URI(String.format("http://" + serviceName + "/random-service/next"));
		log.info("URL: {}", uri);
		Map<String, Object> mapResponse = loadBalancedRestTemplate.getForObject(uri, Map.class);

		log.info("[load-balanced-rest-template] {} response: {}", serviceName, mapResponse);

		return (int) mapResponse.get("random");
	}

}
