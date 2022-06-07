package com.example.template;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

@SpringBootApplication
public class Application {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);
    }

    // @Bean
	// public HttpClient getHttpClient(){
	// 	ConnectionProvider connectionProvider= ConnectionProvider.elastic("gw connection pool(60s time out)", Duration.ofSeconds(60l));
	// 	return HttpClient.create(connectionProvider);
	// }
}
