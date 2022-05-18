
package petstore;
import petstore.config.kafka.KafkaProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class PetApplication {

    static String[] names={"젤리","대박이","감자","사랑","자몽이","꼬맹이","몽이","모리","하리","해피","하트","콩","태양"};
    
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {

        Pet pet = new Dog();

		System.out.println("energy is " + pet.getEnergy());

		pet.eat();
		System.out.println("energy is " + pet.getEnergy());

		pet.sleep();
		System.out.println("energy is " + pet.getEnergy());

        applicationContext = SpringApplication.run(PetApplication.class, args);
    }


}