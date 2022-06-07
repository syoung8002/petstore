package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Groomed extends AbstractEvent {

    private Long id;
    private Integer energy;
    private Integer appearance;
    private String status;
    private String name;

    public Groomed(Pet aggregate) {
        super(aggregate);
    }

    public Groomed() {
        super();
    }
    // keep

}
