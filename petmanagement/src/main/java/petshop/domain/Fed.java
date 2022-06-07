package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Fed extends AbstractEvent {

    private Long id;
    private Integer energy;
    private Integer appearance;
    private String status;
    private String name;

    public Fed(Pet aggregate) {
        super(aggregate);
    }

    public Fed() {
        super();
    }
    // keep

}
