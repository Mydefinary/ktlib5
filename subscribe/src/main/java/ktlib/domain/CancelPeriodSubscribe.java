package ktlib.domain;

import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

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
}
