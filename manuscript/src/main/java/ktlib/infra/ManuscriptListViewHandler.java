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
public class ManuscriptListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ManuscriptListRepository manuscriptListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenResisteredText_then_CREATE_1(
        @Payload ResisteredText resisteredText
    ) {
        try {
            if (!resisteredText.validate()) return;

            // view 객체 생성
            ManuscriptList manuscriptList = new ManuscriptList();
            // view 객체에 이벤트의 Value 를 set 함
            manuscriptList.setManuscriptId(resisteredText.getManuscriptId());
            manuscriptList.setTitle(resisteredText.getTitle());
            manuscriptList.setContent(resisteredText.getContent());
            manuscriptList.setCreatedDate(
                String.valueOf(resisteredText.getCreatedDate())
            );
            manuscriptList.setLastModified(
                String.valueOf(resisteredText.getLastModified())
            );
            manuscriptList.setAuthorId(
                String.valueOf(resisteredText.getAuthorId())
            );
            manuscriptList.setStatus(resisteredText.getStatus());
            // view 레파지 토리에 save
            manuscriptListRepository.save(manuscriptList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRequestedPublish_then_UPDATE_1(
        @Payload RequestedPublish requestedPublish
    ) {
        try {
            if (!requestedPublish.validate()) return;
            // view 객체 조회
            Optional<ManuscriptList> manuscriptListOptional = manuscriptListRepository.findByManuscriptId(
                requestedPublish.getManuscriptId()
            );

            if (manuscriptListOptional.isPresent()) {
                ManuscriptList manuscriptList = manuscriptListOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                manuscriptList.setStatus(requestedPublish.getStatus());
                // view 레파지 토리에 save
                manuscriptListRepository.save(manuscriptList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpdatedText1_then_UPDATE_2(
        @Payload UpdatedText1 updatedText1
    ) {
        try {
            if (!updatedText1.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
