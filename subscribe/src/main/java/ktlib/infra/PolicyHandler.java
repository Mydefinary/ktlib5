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
    SubscribeSuRepository subscribeSuRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='NotDecreasedPoints'"
    )
    public void wheneverNotDecreasedPoints_FailBookSubscribe(
        @Payload NotDecreasedPoints notDecreasedPoints
    ) {
        NotDecreasedPoints event = notDecreasedPoints;
        System.out.println(
            "\n\n##### listener FailBookSubscribe : " +
            notDecreasedPoints +
            "\n\n"
        );

        // Sample Logic //
        SubscribeSu.failBookSubscribe(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PeriodSubscribed'"
    )
    public void wheneverPeriodSubscribed_UpdateRecurringSubscription(
        @Payload PeriodSubscribed periodSubscribed
    ) {
        PeriodSubscribed event = periodSubscribed;
        System.out.println(
            "\n\n##### listener UpdateRecurringSubscription : " +
            periodSubscribed +
            "\n\n"
        );

        // Comments //
        //정기구독 신청시 정기구독일이 늘고
        // 정기구독 취소시(예: KT통신사 이동 등) 정기구독일이 줄어들음

        // Sample Logic //
        SubscribeSu.updateRecurringSubscription(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CancelPeriodSubscribe'"
    )
    public void wheneverCancelPeriodSubscribe_UpdateRecurringSubscription(
        @Payload CancelPeriodSubscribe cancelPeriodSubscribe
    ) {
        CancelPeriodSubscribe event = cancelPeriodSubscribe;
        System.out.println(
            "\n\n##### listener UpdateRecurringSubscription : " +
            cancelPeriodSubscribe +
            "\n\n"
        );

        // Comments //
        //정기구독 신청시 정기구독일이 늘고
        // 정기구독 취소시(예: KT통신사 이동 등) 정기구독일이 줄어들음

        // Sample Logic //
        SubscribeSu.updateRecurringSubscription(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
