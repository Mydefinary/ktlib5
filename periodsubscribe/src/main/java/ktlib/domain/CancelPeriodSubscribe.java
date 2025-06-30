package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CancelPeriodSubscribe extends AbstractEvent {

    private Long recurringSubscriptionId;
    private Long userId;
    private Date startedAt;
    private Date nextPaymentDue;
    private Boolean isActive;
    private Date lastPaymentAt;
    private Boolean accessGranted;

    public CancelPeriodSubscribe(PeriodSubscribe aggregate) {
        super(aggregate);
    }

    public CancelPeriodSubscribe() {
        super();
    }
}
//>>> DDD / Domain Event
