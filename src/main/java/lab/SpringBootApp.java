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
            repo.save(new BuddyInfo("Lava", "613-555-5555"));
            repo.save(new BuddyInfo("Boo", "613-555-5554"));
            repo.save(new BuddyInfo("Bob", "613-555-5553"));
            repo.save(new BuddyInfo("Bill", "613-555-5552"));

            /*

            log.info("BuddyInfo found with findAll():");
            log.info("------------------------------");
            for(BuddyInfo b : repo.findAll()){
                log.info(b.toString());
            }
            log.info("------------------------------");
            BuddyInfo b1 = repo.findOne("613-555-5554");
            log.info("Buddy found with findOne('613-555-5554'):");
            log.info("------------------------------");
            log.info(b1.toString());
            log.info("------------------------------");

            log.info("Buddy found with findByName('Lava')");
            log.info("------------------------------");
            for(BuddyInfo b : repo.findByName("Lava")){
                log.info(b.toString());
            }
            log.info("------------------------------");
            */
        };
    }
}