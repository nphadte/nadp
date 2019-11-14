package com.rocketbnk.nadp;

import com.rocketbnk.nadp.controller.NotePadController;
import com.rocketbnk.nadp.util.Notepad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(NadpApplication.class);

	@PostConstruct
	void init(){
		/*
		 *  Initialise by creating the Singleton notepad text file
		 */
		Notepad notepad = new Notepad();
		logger.info("The Singleton File hasb been created is" );

	}

	public static void main(String[] args) {
		SpringApplication.run(NadpApplication.class, args);
	}

}
