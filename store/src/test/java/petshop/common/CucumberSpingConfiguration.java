package petshop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import petshop.StoreApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreApplication.class })
public class CucumberSpingConfiguration {}
