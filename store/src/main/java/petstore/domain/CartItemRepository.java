
package petstore.domain;

import petstore.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="cartItems", path="cartItems")
public interface CartItemRepository extends PagingAndSortingRepository<CartItem, Long>{


}

