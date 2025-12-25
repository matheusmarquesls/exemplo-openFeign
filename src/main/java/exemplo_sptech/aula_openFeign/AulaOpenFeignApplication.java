package exemplo_sptech.aula_openFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients // habilitar o Spring para usar o Feign
@SpringBootApplication
public class AulaOpenFeignApplication {

	public static void main(String[] args) {

		SpringApplication.run(AulaOpenFeignApplication.class, args);
	}

}
