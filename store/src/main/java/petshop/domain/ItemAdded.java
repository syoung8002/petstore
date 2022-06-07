package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class ItemAdded extends AbstractEvent {

    private Long id;

    public ItemAdded(Item aggregate) {
        super(aggregate);
    }

    public ItemAdded() {
        super();
    }
    // keep

}
