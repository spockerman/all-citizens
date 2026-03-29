package br.com.all.citizens.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        String active = System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME);
        if (active == null || active.isBlank()) {
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "development");
        }
        SpringApplication.run(Main.class, args);
    }
}
