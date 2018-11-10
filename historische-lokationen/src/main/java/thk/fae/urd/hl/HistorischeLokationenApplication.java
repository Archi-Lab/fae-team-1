package thk.fae.urd.hl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("thk.fae.urd.hl.repo") 
@EntityScan("thk.fae.urd.hl.model")
@SpringBootApplication
public class HistorischeLokationenApplication {

    public static void main(String[] args) {
        SpringApplication.run(HistorischeLokationenApplication.class, args);
    }
}
