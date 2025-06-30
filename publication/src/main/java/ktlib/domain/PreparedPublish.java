package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PreparedPublish extends AbstractEvent {

    private Long publicationId;
    private Long manuscriptId;
    private String coverUrl;
    private String genre;
    private String summary;
    private Long readCost;
    private Date publicationDate;

    public PreparedPublish(Publish aggregate) {
        super(aggregate);
    }

    public PreparedPublish() {
        super();
    }
}
//>>> DDD / Domain Event
