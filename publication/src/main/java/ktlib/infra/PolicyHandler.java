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
    PublishRepository publishRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RequestedPublish'"
    )
    public void wheneverRequestedPublish_PreparePublish(
        @Payload RequestedPublish requestedPublish
    ) {
        RequestedPublish event = requestedPublish;
        System.out.println(
            "\n\n##### listener PreparePublish : " + requestedPublish + "\n\n"
        );

        // Sample Logic //
        Publish.preparePublish(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
