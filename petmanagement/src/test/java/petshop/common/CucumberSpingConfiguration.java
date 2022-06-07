package petshop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import petshop.PetmanagementApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { PetmanagementApplication.class })
public class CucumberSpingConfiguration {}
