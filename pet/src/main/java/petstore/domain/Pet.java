
package petstore.domain;

import petstore.domain.PetReserved;
import petstore.PetApplication;
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
    name = "pet"
    columnDefinition = "CHAR(5)"
)
public abstract class Pet {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
        public Long getId() {
            return id;
        }

    
    private int appearance;
        public int getAppearance() {
            return appearance;
        }
        protected void setAppearance(int appearance) {
            this.appearance = appearance;
        }
    
    
    String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            if(name==null) throw new IllegalArgumentException("이름은 꼭 들어가야 합니다");
            this.name = name;
        }
    
    
    String type;
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    
    
    private int energy;
        public int getEnergy() {
            return energy;
        }
        protected void setEnergy(int energy) {
            if(Math.abs(this.energy - energy) < 3 )
                this.energy = energy;
            else    
                throw new IllegalArgumentException("Energy change is too big");
        }


    abstract public void speak();


    @PostPersist
    public void onPostPersist(){
        PetReserved petReserved = new PetReserved();
        BeanUtils.copyProperties(this, petReserved);
        petReserved.publishAfterCommit();

    }


    public void eat(){
        energy += 1;

    }
    

    public void sleep(){
        energy += 2;
        
    }


}
