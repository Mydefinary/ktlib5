package ktlib.domain;

import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class BookSubscribed extends AbstractEvent {

    private Long subscriptionId;
    private Long bookId;
    private Long userId;
    private Date subscribedAt;
    private Date expriedAt;
    private Date paymentAt;
    private Boolean paymentSuccess;
    private Long readCost;
}
