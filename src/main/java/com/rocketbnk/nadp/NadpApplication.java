package com.rocketbnk.nadp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		NadpApplication.class,
		Jsr310JpaConverters.class
})
public class NadpApplication {

	@PostConstruct
	void init(){
		/*
		 *  Initialise by creating the Singleton notepad text file
		 */
	}

	public static void main(String[] args) {
		SpringApplication.run(NadpApplication.class, args);
	}

}
