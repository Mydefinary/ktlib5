package ktlib.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "BookList_table")
@Data
public class BookList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookId;

    private Long authorId;
    private Date registrationDate;
    private Date publicationDate;
    private Long numberOfSubscribers;
    private Long publicationId;
    private Long manuscriptId;
    private String title;
    private String content;
    private String genre;
    private String summary;
    private String coverUrl;
    private String authorName;
    private Long readCost;
    private String authorNickname;
}
