package edu.mtisw.payrollbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayrollBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollBackendApplication.class, args);
	}

}
