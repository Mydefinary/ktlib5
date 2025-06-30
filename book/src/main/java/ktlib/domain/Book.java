package ktlib.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktlib.BookApplication;
import ktlib.domain.GivenBestseller;
import ktlib.domain.RegistedBook;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private Date registrationDate;

    private Date publicationDate;

    private Long numberOfSubscribers;

    private Long publicationId;

    private Long manuscriptId;

    private Long authorId;

    private String status;

    public static BookRepository repository() {
        BookRepository bookRepository = BookApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registBook(PreparedPublish preparedPublish) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        RegistedBook registedBook = new RegistedBook(book);
        registedBook.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if preparedPublish.llmGptId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> publishMap = mapper.convertValue(preparedPublish.getLlmGptId(), Map.class);

        repository().findById(preparedPublish.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            RegistedBook registedBook = new RegistedBook(book);
            registedBook.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void giveBestseller(BookSubscribed bookSubscribed) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        GivenBestseller givenBestseller = new GivenBestseller(book);
        givenBestseller.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(bookSubscribed.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            GivenBestseller givenBestseller = new GivenBestseller(book);
            givenBestseller.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
