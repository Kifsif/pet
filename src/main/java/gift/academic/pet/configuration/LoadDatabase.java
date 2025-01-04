package gift.academic.pet.configuration;

import gift.academic.pet.models.User;
import gift.academic.pet.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("+75894589332",
                    "borzoy@mal.ru",
                    "Борзомысл",
                    "Password1",
                    "Password1",
                    "on",
                    "fc4de241-3041-4bb5-89a2-6da6b1a15e21")));
            log.info("Preloading " + repository.save(new User(
                    "+75681234565",
                    "grandmother@mal.ru",
                    "Бабушка Европы",
                    "Password1",
                    "Password1",
                    "on",
                    "78dc1018-9d3b-4cc7-9525-1dcd130041a4")));
        };
    }
}