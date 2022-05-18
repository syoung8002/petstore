
package petstore.infra;
import petstore.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
@RequestMapping(value="/pets")
@Transactional
public class PetController {

	@Autowired
	PetRepository petRepository;

	
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/feed")
	public String feedPet(@PathVariable(value = "petId") Long petId){

		Pet thePet = petRepository.findById(petId).get();

		thePet.eat();

		petRepository.save(thePet);

		return "맛있는 거 먹였습니다.";
	}

	

}
