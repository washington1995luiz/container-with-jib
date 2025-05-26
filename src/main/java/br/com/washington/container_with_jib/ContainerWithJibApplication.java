package br.com.washington.container_with_jib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableDiscoveryClient
@SpringBootApplication
public class ContainerWithJibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainerWithJibApplication.class, args);
	}

}
