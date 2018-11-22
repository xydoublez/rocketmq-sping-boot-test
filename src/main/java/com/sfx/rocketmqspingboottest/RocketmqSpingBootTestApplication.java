package com.sfx.rocketmqspingboottest;

import com.maihaoche.starter.mq.annotation.EnableMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMQConfiguration
public class RocketmqSpingBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketmqSpingBootTestApplication.class, args);
	}
}
