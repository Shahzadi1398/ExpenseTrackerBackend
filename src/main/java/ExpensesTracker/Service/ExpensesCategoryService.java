package ExpensesTracker.Service;

import ExpensesTracker.Modal.ExpensesCategory;
import ExpensesTracker.Modal.PaymentCategory;
import ExpensesTracker.Modal.SignUp;
import ExpensesTracker.Repo.ExpensesCategoryRepo;
import ExpensesTracker.Repo.PaymentCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 06-03-2024
 * @Weekday : Wednesday
 **/

@Service
public class ExpensesCategoryService {

    @Autowired
    ExpensesCategoryRepo expensesCategoryRepo;

    @Autowired
    PaymentCategoryRepo paymentCategoryRepo;

    public List<ExpensesCategory> getExpensesData(){
        return expensesCategoryRepo.findAll();
    }

    public void saveExpensesCategory(ExpensesCategory expensesCategory){
        LocalDate date = LocalDate.now();
        expensesCategory.setEntryDt(date);
        expensesCategoryRepo.save(expensesCategory);
    }

    public void deleteExpensesCategoryById(String uuid){
        expensesCategoryRepo.deleteById(uuid);
    }

    public List<PaymentCategory> getPaymentCategory(){
        return paymentCategoryRepo.findAll();
    }

    public void savePaymentCategory(PaymentCategory paymentCategory){
        LocalDate date = LocalDate.now();
        paymentCategory.setEntryDt(date);
        paymentCategoryRepo.save(paymentCategory);
    }

}
