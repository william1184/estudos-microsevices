package br.com.unlimitedapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsuarioMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioMicroserviceApplication.class, args);
	}

}
