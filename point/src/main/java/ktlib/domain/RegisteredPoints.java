package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RegisteredPoints extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Long pointBalance;
    private Date pointRechargeDate;
    private Date pointSpendDate;

    public RegisteredPoints(Point aggregate) {
        super(aggregate);
    }

    public RegisteredPoints() {
        super();
    }
}
//>>> DDD / Domain Event
