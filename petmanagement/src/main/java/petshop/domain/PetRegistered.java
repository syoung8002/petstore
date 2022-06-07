package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class PetRegistered extends AbstractEvent {

    private Long id;
    private Integer energy;
    private Integer appearance;
    private String status;

    public PetRegistered(Pet aggregate) {
        super(aggregate);
    }

    public PetRegistered() {
        super();
    }
    // keep

}
