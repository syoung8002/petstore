package petshop.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petshop.domain.*;

@RestController
@RequestMapping(value = "/items")
@Transactional
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(
        value = "/{id}/adopt",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Item adopt(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /item/adopt  called #####");
        Optional<Item> optionalItem = itemRepository.findById(id);

        optionalItem.orElseThrow(() -> new Exception("No Entity Found"));
        Item item = optionalItem.get();
        item.adopt();

        itemRepository.save(item);
        return item;
    }

    @RequestMapping(
        value = "/{id}/dissolute",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Item dissolute(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /item/dissolute  called #####");
        Optional<Item> optionalItem = itemRepository.findById(id);

        optionalItem.orElseThrow(() -> new Exception("No Entity Found"));
        Item item = optionalItem.get();
        item.dissolute();

        itemRepository.save(item);
        return item;
    }
    // keep
}
