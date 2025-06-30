package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class RegistedBook extends AbstractEvent {

    private Long bookId;
    private Long authorId;
    private Date registrationDate;
    private Date publicationDate;
    private Long numberOfSubscribers;
    private Long publicationId;
}
