package ktlib.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "AuthorList_table")
@Data
public class AuthorList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long authorId;

    private String authorName;
    private String authorNickname;
    private String phoneNumber;
    private String email;
}
