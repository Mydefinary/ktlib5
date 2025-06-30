package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class GivenBestseller extends AbstractEvent {

    private Long bookId;
    private Long authorId;
    private Long numberOfSubscribers;
    private Long publicationId;

    public GivenBestseller(Book aggregate) {
        super(aggregate);
    }

    public GivenBestseller() {
        super();
    }
}
//>>> DDD / Domain Event
