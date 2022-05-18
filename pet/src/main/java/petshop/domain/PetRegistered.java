package petshop.domain;

import petshop.domain.*;
import petshop.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private int appearance;
    private int energy;

    public PetRegistered(){
        super();
    }
}

<function>