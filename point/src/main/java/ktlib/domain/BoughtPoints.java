package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BoughtPoints extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Long pointBalance;
    private Date pointRechargeDate;

    public BoughtPoints(Point aggregate) {
        super(aggregate);
    }

    public BoughtPoints() {
        super();
    }
}
//>>> DDD / Domain Event
