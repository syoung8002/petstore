
package petstore.domain;

import petstore.domain.*;
import petstore.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class PetReserved extends AbstractEvent {

    Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    private int appearance;
    public int getAppearance() {
        return appearance;
    }
    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
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
    public void setEnergy(int energy) {
        
        this.energy = energy;
    }


    // public PetReserved(){
    //     super();
    // }


}