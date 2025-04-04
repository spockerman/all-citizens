package br.com.all.citizens.infrastructure;


import org.junit.jupiter.api.Test;
import org.springframework.core.env.AbstractEnvironment;

public class MainTest {

    @Test
    public void testMain(){
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test");
        Main.main(new String[]{

        });
    }
}
