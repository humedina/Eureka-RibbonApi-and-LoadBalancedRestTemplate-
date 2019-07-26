package com.consulting.mgt.springboot.practica23.ribbon.randommicroservice.restcontroller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica23.ribbon.randommicroservice.MyListener;
import com.consulting.mgt.springboot.practica23.ribbon.randommicroservice.client.RandomServiceClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RandomRestController {

	@Autowired
	private Environment env;
	
	@Autowired
	private RandomServiceClient randomServiceClient;

	@GetMapping("/next")
	public Map<String, Object> age() {

		log.info("returning random");

		Map<String, Object> map = new LinkedHashMap<>();

		map.put("random", randomServiceClient.getRandomValue());
		map.put("from", "http://" + env.getProperty("spring.application.name") + ":" + MyListener.APPLICATION_PORT);

		return map;
	}
}
