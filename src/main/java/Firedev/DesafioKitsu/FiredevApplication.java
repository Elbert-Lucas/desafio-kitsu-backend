package Firedev.DesafioKitsu;

import Firedev.DesafioKitsu.Client.AnimeClient;
import Firedev.DesafioKitsu.Domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
@Log4j2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class } )
public class FiredevApplication {


	public static void main(String[] args) {
		SpringApplication.run(FiredevApplication.class, args);
	}
}
