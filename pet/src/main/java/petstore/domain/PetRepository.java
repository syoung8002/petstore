
package petstore.domain;

import petstore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="pets", path="pets")
public interface PetRepository extends PagingAndSortingRepository<Pet, Long>{


}
