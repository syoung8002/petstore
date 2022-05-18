package petshop.domain;

import petshop.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="pets", path="pets")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long>{


}

<function>