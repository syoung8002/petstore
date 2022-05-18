
package petstore.domain;

import petstore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="dogs", path="dogs")
public interface DogRepository extends PagingAndSortingRepository<Dog, Long>{


}
