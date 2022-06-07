package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class PriceSet extends AbstractEvent {

    private Long id;

    public PriceSet(Item aggregate) {
        super(aggregate);
    }

    public PriceSet() {
        super();
    }
    // keep

}
