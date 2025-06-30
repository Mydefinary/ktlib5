package ktlib.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ktlib.config.kafka.KafkaProcessor;
import ktlib.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookSubscribed'"
    )
    public void wheneverBookSubscribed_DecreasePoints(
        @Payload BookSubscribed bookSubscribed
    ) {
        BookSubscribed event = bookSubscribed;
        System.out.println(
            "\n\n##### listener DecreasePoints : " + bookSubscribed + "\n\n"
        );

        // Sample Logic //
        Point.decreasePoints(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RegisteredUser'"
    )
    public void wheneverRegisteredUser_RegisterPoints(
        @Payload RegisteredUser registeredUser
    ) {
        RegisteredUser event = registeredUser;
        System.out.println(
            "\n\n##### listener RegisterPoints : " + registeredUser + "\n\n"
        );

        // Sample Logic //
        Point.registerPoints(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
