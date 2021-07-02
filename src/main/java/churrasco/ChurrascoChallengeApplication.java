package churrasco;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("churrasco.repositories")
@EntityScan("churrasco.entities")
public class ChurrascoChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChurrascoChallengeApplication.class, args);
    }

    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }

}
