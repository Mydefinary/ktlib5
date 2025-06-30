package ktlib.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlib.ManuscriptApplication;
import ktlib.domain.RequestedPublish;
import ktlib.domain.ResisteredText;
import ktlib.domain.UpdatedText1;
import lombok.Data;

@Entity
@Table(name = "Manuscript_table")
@Data
//<<< DDD / Aggregate Root
public class Manuscript {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long manuscriptId;

    private String title;

    private String content;

    private String status;

    private Date createdDate;

    private Date lastModified;

    private Long authorId;

    private String authorNickname;

    @PostPersist
    public void onPostPersist() {
        ResisteredText resisteredText = new ResisteredText(this);
        resisteredText.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        RequestedPublish requestedPublish = new RequestedPublish(this);
        requestedPublish.publishAfterCommit();

        UpdatedText1 updatedText1 = new UpdatedText1(this);
        updatedText1.publishAfterCommit();
    }

    public static ManuscriptRepository repository() {
        ManuscriptRepository manuscriptRepository = ManuscriptApplication.applicationContext.getBean(
            ManuscriptRepository.class
        );
        return manuscriptRepository;
    }
}
//>>> DDD / Aggregate Root
