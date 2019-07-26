package com.consulting.mgt.springboot.practica23.ribbon.randommicroservice.client;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RandomServiceClient {

	@Autowired
	private Random random;

	public int getRandomValue() {
		return random.nextInt(40);
	}

}
