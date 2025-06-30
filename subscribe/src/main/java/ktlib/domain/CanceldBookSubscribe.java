package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class CanceldBookSubscribe extends AbstractEvent {

    private Long subscriptionId;
    private Long bookId;
    private Long userId;
    private Date subscribedAt;
    private Date expriedAt;
    private Date paymentAt;
    private Boolean paymentSuccess;

    public CanceldBookSubscribe(SubscribeSu aggregate) {
        super(aggregate);
    }

    public CanceldBookSubscribe() {
        super();
    }
}
//>>> DDD / Domain Event
