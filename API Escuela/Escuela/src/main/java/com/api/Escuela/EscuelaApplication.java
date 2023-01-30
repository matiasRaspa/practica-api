package com.api.Escuela;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscuelaApplication {

	public static void main(String[] args) {

		//Configuracion log4j para errores globales
		PropertyConfigurator.configure("log4j.properties");

		SpringApplication.run(EscuelaApplication.class, args);
	}

}
