package org.sedaq.soap;

import org.sedaq.soap.config.WebServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebServiceConfig.class)
public class SoapServerSideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServerSideApplication.class, args);
    }

}
