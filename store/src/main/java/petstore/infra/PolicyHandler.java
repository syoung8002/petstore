
package petstore.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;

import petstore.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petstore.domain.*;


@Service
public class PolicyHandler{
    @Autowired CartItemRepository cartItemRepository;
    @Autowired ItemRepository itemRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}


