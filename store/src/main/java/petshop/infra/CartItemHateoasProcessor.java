package petshop.infra;
import petshop.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CartItemHateoasProcessor implements RepresentationModelProcessor<EntityModel<CartItem>>  {

    @Override
    public EntityModel<CartItem> process(EntityModel<CartItem> model) {
        
        return model;
    }
    
}

