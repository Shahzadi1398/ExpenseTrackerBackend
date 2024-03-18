package ExpensesTracker.Repo;

import ExpensesTracker.Modal.ExpensesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 04-03-2024
 * @Weekday : Monday
 **/

@Repository
public interface ExpensesCategoryRepo extends JpaRepository<ExpensesCategory, String> {
}
