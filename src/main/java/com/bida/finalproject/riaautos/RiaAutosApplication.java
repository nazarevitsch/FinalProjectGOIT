package com.bida.finalproject.riaautos;

import com.bida.finalproject.riaautos.domain.Region;
import com.bida.finalproject.riaautos.request.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bida.finalproject.riaautos"})
public class RiaAutosApplication {

	public static void main(String[] args){

		SpringApplication.run(RiaAutosApplication.class, args);
	}
}
