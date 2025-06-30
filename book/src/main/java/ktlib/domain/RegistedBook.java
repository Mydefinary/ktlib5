package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RegistedBook extends AbstractEvent {

    private Long bookId;
    private Long authorId;
    private Date registrationDate;
    private Date publicationDate;
    private Long numberOfSubscribers;
    private Long publicationId;

    public RegistedBook(Book aggregate) {
        super(aggregate);
    }

    public RegistedBook() {
        super();
    }
}
//>>> DDD / Domain Event
