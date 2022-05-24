package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class PetRegistered extends AbstractEvent {

    private Long id;
    private String name;
    private int appearance;
    private int energy;
}
