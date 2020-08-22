package com.bida.finalproject.riaautos;

import com.bida.finalproject.riaautos.request.CreateDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bida.finalproject.riaautos"})
public class RiaAutosApplication {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(RiaAutosApplication.class, args);

//		CreateDB createDB = new CreateDB();
//		createDB.createModelsTable();



//		Request request = new Request();
//		request.getAllAutoCategories();
//		request.getAllBodyStylesByCategoryID(1);
//		String s = request.getAllMarksByCategoryID(1);
//		System.out.println(s.substring(s.indexOf("Volv")));
//		System.out.println(s.substring(s.indexOf("Toy")));
//		System.out.println(s.substring(s.indexOf("Ho")));
//		System.out.println(s.substring(s.indexOf("Inf")));
//		request.search();
	}

}
