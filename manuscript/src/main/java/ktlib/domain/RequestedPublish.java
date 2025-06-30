package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RequestedPublish extends AbstractEvent {

    private Long manuscriptId;
    private String title;
    private String content;
    private String status;
    private Long authorId;
    private String authorNickname;

    public RequestedPublish(Manuscript aggregate) {
        super(aggregate);
    }

    public RequestedPublish() {
        super();
    }
}
//>>> DDD / Domain Event
