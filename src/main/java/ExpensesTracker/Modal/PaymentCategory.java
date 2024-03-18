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
@Table(name = "paymentCategory")
public class PaymentCategory {

    @Id
    @Column(name = "\"paymentName\"")
    private String paymentName;

    @Column(name = "\"paymentShortName\"")
    private String paymentShortName;

    @Column(name = "\"entryDt\"")
    private LocalDate entryDt;
}
