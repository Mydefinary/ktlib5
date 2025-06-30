package ktlib.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlib.PeriodsubscribeApplication;
import ktlib.domain.CancelPeriodSubscribe;
import ktlib.domain.PeriodSubscribed;
import lombok.Data;

@Entity
@Table(name = "PeriodSubscribe_table")
@Data
//<<< DDD / Aggregate Root
public class PeriodSubscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recurringSubscriptionId;

    private Long userId;

    private Date startedAt;

    private Date nextPaymentDue;

    private Boolean isActive;

    private Date lastPaymentAt;

    private Boolean accessGranted;

    @PostPersist
    public void onPostPersist() {
        PeriodSubscribed periodSubscribed = new PeriodSubscribed(this);
        periodSubscribed.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CancelPeriodSubscribe cancelPeriodSubscribe = new CancelPeriodSubscribe(
            this
        );
        cancelPeriodSubscribe.publishAfterCommit();
    }

    public static PeriodSubscribeRepository repository() {
        PeriodSubscribeRepository periodSubscribeRepository = PeriodsubscribeApplication.applicationContext.getBean(
            PeriodSubscribeRepository.class
        );
        return periodSubscribeRepository;
    }
}
//>>> DDD / Aggregate Root
