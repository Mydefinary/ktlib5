package ktlib.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "PointsList_table")
@Data
public class PointsList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long pointId;

    private Long userId;
    private Long pointBalance;
    private Date pointRechargeDate;
    private Date pointSpendDate;
    private Long readCost;
}
