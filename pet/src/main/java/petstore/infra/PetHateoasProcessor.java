package petstore.infra;
import petstore.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PetHateoasProcessor implements RepresentationModelProcessor<EntityModel<Pet>>  {

    @Override
    public EntityModel<Pet> process(EntityModel<Pet> model) {
        
        return model;
    }
    
}

