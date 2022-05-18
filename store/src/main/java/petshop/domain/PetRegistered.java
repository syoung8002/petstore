package petshop.domain;

import petshop.domain.*;
import petshop.infra.AbstractEvent;
import lombok.Data;
import java.util.Date;
@Data
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private int appearance;
    private int energy;

}

