
package petstore.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
public class Pet  {


    @Id
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





}

