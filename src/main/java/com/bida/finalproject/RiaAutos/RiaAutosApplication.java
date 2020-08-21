package com.bida.finalproject.RiaAutos;

import com.bida.finalproject.RiaAutos.request.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RiaAutosApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(RiaAutosApplication.class, args);
		Request request = new Request();
//		request.getAllAutoCategories();
//		request.getAllBodyStylesByCategoryID(1);
//		request.getAllMarksByCategoryID(1);
//		request.search();
	}

}
