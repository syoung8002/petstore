package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Slept extends AbstractEvent {

    private Long id;
    private Integer energy;
    private Integer appearance;
    private String status;
    private String name;

    public Slept(Pet aggregate) {
        super(aggregate);
    }

    public Slept() {
        super();
    }
    // keep

}
