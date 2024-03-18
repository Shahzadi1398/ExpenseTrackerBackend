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
@Table(name = "singUp")
public class SignUp {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "\"uuidId\"",nullable = false)
    private UUID uuidId;

    @Column(name = "\"firstName\"")
    private String firstName;

    @Column(name = "\"lastName\"")
    private String lastName;

    @Column(name = "\"email\"")
    private String email;

    @Column(name = "\"password\"")
    private String password;

    @Column(name = "\"entryDt\"")
    private LocalDate entryDt;

    @Column(name = "\"lastLogin\"")
    private LocalDate lastLogin;

    @Column(name = "\"isLoggedIn\"")
    private Boolean isLoggedIn;
}
