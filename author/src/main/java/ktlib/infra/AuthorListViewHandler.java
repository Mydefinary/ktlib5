package ktlib.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import ktlib.config.kafka.KafkaProcessor;
import ktlib.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AuthorListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private AuthorListRepository authorListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAuthorRegistered_then_CREATE_1(
        @Payload AuthorRegistered authorRegistered
    ) {
        try {
            if (!authorRegistered.validate()) return;

            // view 객체 생성
            AuthorList authorList = new AuthorList();
            // view 객체에 이벤트의 Value 를 set 함
            authorList.setAuthorId(authorRegistered.getAuthorId());
            authorList.setAuthorName(authorRegistered.getAuthorName());
            authorList.setAuthorNickname(authorRegistered.getAuthorNickname());
            authorList.setPhoneNumber(authorRegistered.getPhoneNumber());
            authorList.setEmail(authorRegistered.getEmail());
            // view 레파지 토리에 save
            authorListRepository.save(authorList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
