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
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "\"uuidId\"",nullable = false)
    private UUID uuidId;

    @Column(name = "\"expensesName\"")
    private String expensesName;

    @Column(name = "\"amount\"")
    private Integer amount;

    @Column(name = "\"expenseDt\"")
    private LocalDate expenseDt;

    @Column(name = "\"comment\"")
    private String comment;

    @Column(name = "\"expensesCategory\"")
    private String expensesCategory;

    @Column(name = "\"paymentCategory\"")
    private String paymentCategory;

    @ManyToOne
    @JoinColumn(name = "\"userData\"", referencedColumnName = "\"uuidId\"" )
    SignUp signUp;
}
