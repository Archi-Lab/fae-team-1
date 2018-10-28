package thk.fae.urd.lh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableJpaRepositories("thk.fae.urd.lh.repo") 
@EntityScan("thk.fae.urd.lh.model")
@SpringBootApplication
public class LocationHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationHistoryApplication.class, args);
    }

      @Bean
        public Docket swaggerEmployeeApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("thk.fae.urd.lh.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Location History API").description("Documentation Location History API v1.0").build());
        }  
}
