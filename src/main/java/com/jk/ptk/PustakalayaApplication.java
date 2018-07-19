package com.jk.ptk;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.jk.ptk.app.Initializer;

/**
 * Starting point for this Spring application.
 *
 * @author Jitendra
 *
 */

@SpringBootApplication
@EnableWebMvc
public class PustakalayaApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private Initializer initializer;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PustakalayaApplication.class);
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList(args);
		SpringApplication.run(PustakalayaApplication.class, list.toArray(new String[] {}));
	}

	@Override
	public void run(String... args) throws Exception {
		initializer.initialize();
	}
}
