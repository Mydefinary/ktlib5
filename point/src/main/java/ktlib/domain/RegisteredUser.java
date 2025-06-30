package ktlib.domain;

import java.util.*;
import ktlib.domain.*;
import ktlib.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class RegisteredUser extends AbstractEvent {

    private Long userId;
    private String name;
    private Long point;
}
