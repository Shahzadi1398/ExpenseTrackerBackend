package ExpensesTracker.Controller;

import ExpensesTracker.Modal.ExpensesCategory;
import ExpensesTracker.Modal.PaymentCategory;
import ExpensesTracker.Modal.ResponseMessage;
import ExpensesTracker.Modal.SignUp;
import ExpensesTracker.Service.ExpensesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 06-03-2024
 * @Weekday : Wednesday
 **/

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/expensesData")
public class ExpensesCategoryController {

    @Autowired
    ExpensesCategoryService expensesCategoryService;

    @GetMapping("/getData")
    public ResponseEntity<?> getExpensesCategoryData() {
        try {
            return new ResponseEntity<>(expensesCategoryService.getExpensesData(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveExpensesCategoryData(@RequestBody ExpensesCategory expensesCategory) {
        try {
            expensesCategoryService.saveExpensesCategory(expensesCategory);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> deleteExpensesCategoryData(@PathVariable("uuid") String uuid) {
        try {
            expensesCategoryService.deleteExpensesCategoryById(uuid);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getPayment")
    public ResponseEntity<?> getPaymentCategoryData() {
        try {
            return new ResponseEntity<>(expensesCategoryService.getPaymentCategory(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/savePayment")
    public ResponseEntity<?> savePaymentCategoryData(@RequestBody PaymentCategory paymentCategory) {
        try {
            expensesCategoryService.savePaymentCategory(paymentCategory);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
