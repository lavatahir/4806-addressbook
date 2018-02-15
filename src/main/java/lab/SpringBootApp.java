package lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApp {
    private static final Logger log = LoggerFactory.getLogger(SpringBootApp.class);

    public static void main(String[] args){
        SpringApplication.run(SpringBootApp.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repo){
        return (args) -> {
        };
    }
}