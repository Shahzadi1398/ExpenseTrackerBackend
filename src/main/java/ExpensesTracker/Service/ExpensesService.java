package ExpensesTracker.Service;

import ExpensesTracker.Modal.Expenses;
import ExpensesTracker.Repo.ExpensesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 11-03-2024
 * @Weekday : Monday
 **/

@Service
public class ExpensesService {

    @Autowired
    ExpensesRepo expensesRepo;


    public void saveExpenses(Expenses expenses){
        expensesRepo.save(expenses);
    }

    public long countExpensesByEmail(String email){
        List<Expenses> expensesList = expensesRepo.findAll();
        return expensesList.stream()
                .filter(e-> e.getSignUp().getEmail().equals(email))
                .count();
    }

    public List<Expenses> getExpensesByEmail(String email){
        LocalDate date = LocalDate.now();
        Integer year = date.getYear();
        List<Expenses> expensesList = expensesRepo.findAll();
        return expensesList.stream()
                .filter(e-> e.getSignUp().getEmail().equals(email))
                .filter(e-> year.equals(e.getExpenseDt().getYear()))
                .sorted(Comparator.comparing(Expenses::getExpenseDt))
                .collect(Collectors.toList());
    }

    public List<Expenses> getExpensesByEmailByDate(String email, LocalDate date){
        Integer year  = date.getYear();
        List<Expenses> expensesList = expensesRepo.findAll();
        return expensesList.stream()
                .filter(e-> e.getSignUp().getEmail().equals(email))
                .filter(e-> year.equals(e.getExpenseDt().getYear()))
                .sorted(Comparator.comparing(Expenses::getExpenseDt))
                .collect(Collectors.toList());
    }

    public List<Expenses> getExpensesByEmailByMonth(String email){
        LocalDate date = LocalDate.now();
        Integer year = date.getYear();
        Integer month  = date.getMonthValue();
        List<Expenses> expensesList = expensesRepo.findAll();
        return expensesList.stream()
                .filter(e-> e.getSignUp().getEmail().equals(email))
                .filter(e-> month.equals(e.getExpenseDt().getMonthValue()))
                .filter(e-> year.equals(e.getExpenseDt().getYear()))
                .sorted(Comparator.comparing(Expenses::getExpenseDt))
                .collect(Collectors.toList());
    }

    public void deleteExpensesById(UUID uuid) {
        expensesRepo.deleteById(uuid);
    }

    public Optional<Expenses> getExpensesById(UUID uuid) {
        return expensesRepo.findById(uuid);
    }

    public void updateExpensesById(UUID uuid, Expenses expenses) {
        Expenses expensesId = expensesRepo.findById(uuid).get();
        expensesId.setAmount(expenses.getAmount());
        expensesId.setComment(expenses.getComment());
        expensesId.setExpenseDt(expenses.getExpenseDt());
        expensesId.setExpensesCategory(expenses.getExpensesCategory());
        expensesId.setExpensesName(expenses.getExpensesName());
        expensesId.setPaymentCategory(expenses.getPaymentCategory());
        expensesRepo.save(expensesId);
    }

    public List<Expenses> getExpensesByEmailByMonthAndYear(String email, Integer month, Integer year) {
        List<Expenses> expensesList = expensesRepo.findAll();
        return expensesList.stream()
                .filter(e-> e.getSignUp().getEmail().equals(email))
                .filter(e-> month.equals(e.getExpenseDt().getMonthValue()))
                .filter(e-> year.equals(e.getExpenseDt().getYear()))
                .sorted(Comparator.comparing(Expenses::getExpenseDt))
                .collect(Collectors.toList());
    }
}
