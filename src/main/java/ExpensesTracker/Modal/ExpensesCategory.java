package ExpensesTracker.Modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 04-03-2024
 * @Weekday : Monday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expensesCategory")
public class ExpensesCategory {

    @Id
    @Column(name = "\"expensesName\"")
    private String expensesName;

    @Column(name = "\"entryDt\"")
    private LocalDate entryDt;
}
