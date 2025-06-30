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
    BookRepository bookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PreparedPublish'"
    )
    public void wheneverPreparedPublish_RegistBook(
        @Payload PreparedPublish preparedPublish
    ) {
        PreparedPublish event = preparedPublish;
        System.out.println(
            "\n\n##### listener RegistBook : " + preparedPublish + "\n\n"
        );

        // Sample Logic //
        Book.registBook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookSubscribed'"
    )
    public void wheneverBookSubscribed_GiveBestseller(
        @Payload BookSubscribed bookSubscribed
    ) {
        BookSubscribed event = bookSubscribed;
        System.out.println(
            "\n\n##### listener GiveBestseller : " + bookSubscribed + "\n\n"
        );

        // Comments //
        //서적구독 신청시 서적 구독자 수를 늘리고
        // 구독자 수가 5명이 넘으면 베스트셀러부여

        // Sample Logic //
        Book.giveBestseller(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
