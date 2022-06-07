package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Dissoluted extends AbstractEvent {

    private Long id;

    public Dissoluted(Item aggregate) {
        super(aggregate);
    }

    public Dissoluted() {
        super();
    }
    // keep

}
