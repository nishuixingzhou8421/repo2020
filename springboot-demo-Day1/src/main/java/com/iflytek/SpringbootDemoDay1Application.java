package com.iflytek;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@EnableRabbit
@SpringBootApplication
@ServletComponentScan //servlet组件扫描
public class SpringbootDemoDay1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoDay1Application.class, args);
	}

}
