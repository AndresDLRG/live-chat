package com.andresdlrg.livechat.start;

import org.dizitart.no2.Nitrite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.andresdlrg.livechat.config.ResourceConfig;
import com.andresdlrg.livechat.config.SecurityConfig;
import com.andresdlrg.livechat.config.WebSocketConfig;

@SpringBootApplication(scanBasePackages={"com.andresdlrg.livechat.service", "com.andresdlrg.livechat.controller"})
@Import({WebSocketConfig.class, ResourceConfig.class, SecurityConfig.class})
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public Nitrite nitrite() {
		return  Nitrite.builder()
			    .compressed()
			    .filePath("./live-chat.db")
			    .openOrCreate("user", "password");
	}
	
}
