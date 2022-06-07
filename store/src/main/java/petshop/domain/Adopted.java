package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Adopted extends AbstractEvent {

    private Long id;

    public Adopted(Item aggregate) {
        super(aggregate);
    }

    public Adopted() {
        super();
    }
    // keep

}
