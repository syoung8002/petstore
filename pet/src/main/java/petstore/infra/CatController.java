
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
@RequestMapping(value="/cats")
@Transactional
public class CatController {

	@Autowired
	CatRepository catRepository;

	
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId){
		
		return feedPet(petId);
	}

}
