package com.imagestudio;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
@EnableEmailTools
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class ImagestudioCrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImagestudioCrmApplication.class, args);
	}
}
