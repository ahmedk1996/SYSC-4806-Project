package Pack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new JBuddy("Jacky", 1224));
            repository.save(new JBuddy("Jacko", 1226));
            repository.save(new JBuddy("Jacku", 1228));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (JBuddy buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");



            // fetch customers by last name
            log.info("Customer found with findByName('Jacky'):");
            log.info("--------------------------------------------");
            repository.findByName("Jacky").forEach(jacky -> {
                log.info(jacky.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}