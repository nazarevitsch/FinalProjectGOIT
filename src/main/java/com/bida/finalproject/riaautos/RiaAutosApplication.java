package com.bida.finalproject.riaautos;

import com.bida.finalproject.riaautos.request.JSONParser;
import com.bida.finalproject.riaautos.request.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bida.finalproject.riaautos"})
public class RiaAutosApplication {

	public static void main(String[] args){

		SpringApplication.run(RiaAutosApplication.class, args);
//		Request request = new Request();
//		String json = request.searchAutoByID("27719768");
//		System.out.println(json.substring(json.indexOf("phone")));
//		JSONParser.parseAndFindAuto(json);
	}
}
