
package petstore.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
public class Customer  {


    @Id
    String id;
    
    @Embedded
    Address address;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public static CustomerRepository repository(){
        CustomerRepository customerRepository = StoreApplication.applicationContext.getBean(CustomerRepository.class);
        return customerRepository;
    }


}

