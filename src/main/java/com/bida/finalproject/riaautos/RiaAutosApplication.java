package com.bida.finalproject.riaautos;

import com.bida.finalproject.riaautos.config.DataBaseConfiguration;
import com.bida.finalproject.riaautos.request.CreateDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bida.finalproject.riaautos"})
public class RiaAutosApplication {


	public static void main(String[] args) throws Exception{


		DataBaseConfiguration dataBaseConfiguration = new DataBaseConfiguration();
		dataBaseConfiguration.createModelsTable();

//		SpringApplication.run(RiaAutosApplication.class, args);

//		CreateDB createDB = new CreateDB();
//		createDB.createModelsTable();
//		createDB.createColorsTable();

	}
}
