package ktlib.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlib.SubscribeApplication;
import ktlib.domain.BookSubscribed;
import ktlib.domain.CanceldBookSubscribe;
import lombok.Data;

@Entity
@Table(name = "SubscribeSu_table")
@Data
//<<< DDD / Aggregate Root
public class SubscribeSu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;

    private Long bookId;

    private Long userId;

    private Date subscribedAt;

    private Date expriedAt;

    private Date paymentAt;

    private Boolean paymentSuccess;

    private Long readCost;

    @PostPersist
    public void onPostPersist() {
        BookSubscribed bookSubscribed = new BookSubscribed(this);
        bookSubscribed.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        CanceldBookSubscribe canceldBookSubscribe = new CanceldBookSubscribe(
            this
        );
        canceldBookSubscribe.publishAfterCommit();
    }

    public static SubscribeSuRepository repository() {
        SubscribeSuRepository subscribeSuRepository = SubscribeApplication.applicationContext.getBean(
            SubscribeSuRepository.class
        );
        return subscribeSuRepository;
    }

    //<<< Clean Arch / Port Method
    public static void failBookSubscribe(
        NotDecreasedPoints notDecreasedPoints
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SubscribeSu subscribeSu = new SubscribeSu();
        repository().save(subscribeSu);

        */

        /** Example 2:  finding and process
        

        repository().findById(notDecreasedPoints.get???()).ifPresent(subscribeSu->{
            
            subscribeSu // do something
            repository().save(subscribeSu);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateRecurringSubscription(
        PeriodSubscribed periodSubscribed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SubscribeSu subscribeSu = new SubscribeSu();
        repository().save(subscribeSu);

        */

        /** Example 2:  finding and process
        

        repository().findById(periodSubscribed.get???()).ifPresent(subscribeSu->{
            
            subscribeSu // do something
            repository().save(subscribeSu);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateRecurringSubscription(
        CancelPeriodSubscribe cancelPeriodSubscribe
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SubscribeSu subscribeSu = new SubscribeSu();
        repository().save(subscribeSu);

        */

        /** Example 2:  finding and process
        

        repository().findById(cancelPeriodSubscribe.get???()).ifPresent(subscribeSu->{
            
            subscribeSu // do something
            repository().save(subscribeSu);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
