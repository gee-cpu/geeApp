package geeapp.gee;

import geeapp.gee.application.properties.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeeApplication.class, args);
    }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder(){
     return new  BCryptPasswordEncoder();
    }
    @Bean
    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }

}
