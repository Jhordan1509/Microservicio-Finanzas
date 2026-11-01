package pe.com.unfpg.finanzas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "pe.com.unfpg.finanzas.client")

public class UnfpgMicroservicioFinanzasApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfpgMicroservicioFinanzasApplication.class, args);
	}

}
