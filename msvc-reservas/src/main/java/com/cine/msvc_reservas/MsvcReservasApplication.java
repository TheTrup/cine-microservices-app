package com.cine.msvc_reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvcReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcReservasApplication.class, args);
	}

}
