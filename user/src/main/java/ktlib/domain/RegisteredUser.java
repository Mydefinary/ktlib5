package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RegisteredUser extends AbstractEvent {

    private Long userId;
    private String name;
    private Long point;

    public RegisteredUser(User aggregate) {
        super(aggregate);
    }

    public RegisteredUser() {
        super();
    }
}
//>>> DDD / Domain Event
