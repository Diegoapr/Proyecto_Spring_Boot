////Esta es la página principal donde correra la aplicación
package com.sena.app;

//Anotaciones que se importan
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Es una anotación que proporciona configuración y funcionalidad preconfigurada para una aplicación Spring Boot
@SpringBootApplication

//La clase SenaAppApplication
public class SenaAppApplication {

	//Realiza la configuración automática basada en las dependencias y componentes presentes en el classpath,
	// y finalmente inicia la aplicación,
	public static void main(String[] args) {
		SpringApplication.run(SenaAppApplication.class, args);
	}

}
