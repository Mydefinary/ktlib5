package ktlib.domain;

import java.time.LocalDate;
import java.util.*;
import ktlib.infra.AbstractEvent;
import lombok.Data;

@Data
public class RequestedPublish extends AbstractEvent {

    private Long manuscriptId;
    private String title;
    private String content;
    private String status;
    private Long authorId;
    private String authorNickname;
}
