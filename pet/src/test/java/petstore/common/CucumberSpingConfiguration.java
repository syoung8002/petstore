package petstore.common;


import petstore.PetApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PetApplication.class })
public class CucumberSpingConfiguration {
    
}
