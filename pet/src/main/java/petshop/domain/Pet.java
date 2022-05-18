
package petshop.domain;

import petshop.domain.PetRegistered;
import petshop.PetApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Pet_table")
@Data
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,
    name = "pet_type",
    columnDefinition = "CHAR(5)"
)
public class Pet  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private String name;
    
    
    private int appearance;
    
    
    private int energy;

    @PostPersist
    public void onPostPersist(){
        PetRegistered petRegistered = new PetRegistered();
        BeanUtils.copyProperties(this, petRegistered);
        petRegistered.publishAfterCommit();

    }

    public void eat(){}
    public void sleep(){}
    public void speak(){}

    public static PetRepository repository(){
        PetRepository petRepository = PetApplication.applicationContext.getBean(PetRepository.class);
        return petRepository;
    }

    public static void feed(){
    }



}

