package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DecreasedPoints extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Long pointBalance;
    private Date subscribedAt;
    private Long readCost;

    public DecreasedPoints(Point aggregate) {
        super(aggregate);
    }

    public DecreasedPoints() {
        super();
    }
}
//>>> DDD / Domain Event
