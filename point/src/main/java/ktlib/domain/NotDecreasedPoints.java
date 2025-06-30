package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class NotDecreasedPoints extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Long pointBalance;
    private Long readCost;

    public NotDecreasedPoints(Point aggregate) {
        super(aggregate);
    }

    public NotDecreasedPoints() {
        super();
    }
}
//>>> DDD / Domain Event
