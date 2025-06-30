package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ResisteredText extends AbstractEvent {

    private Long manuscriptId;
    private Long authorId;
    private String title;
    private String content;
    private Date createdDate;
    private String status;
    private Date lastModified;

    public ResisteredText(Manuscript aggregate) {
        super(aggregate);
    }

    public ResisteredText() {
        super();
    }
}
//>>> DDD / Domain Event
