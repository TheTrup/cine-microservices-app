package com.cine.msvc_funciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsvcFuncionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcFuncionesApplication.class, args);
	}

}
