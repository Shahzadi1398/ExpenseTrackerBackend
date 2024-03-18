package ExpensesTracker.Controller;

import ExpensesTracker.Modal.Expenses;
import ExpensesTracker.Modal.ExpensesCategory;
import ExpensesTracker.Modal.ResponseMessage;
import ExpensesTracker.Service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 11-03-2024
 * @Weekday : Monday
 **/


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    ExpensesService expensesService;

    @PostMapping("/save")
    public ResponseEntity<?> saveExpensesData(@RequestBody List<Expenses> expensesList) {
        try {
            for (Expenses expenses : expensesList) {
                expensesService.saveExpenses(expenses);
            }
            return new ResponseEntity<>(new ResponseMessage("1", "Records saved Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Records not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/get/{email}")
    public ResponseEntity<?> countExpensesDataByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(expensesService.countExpensesByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get1/{email}")
    public ResponseEntity<?> getExpensesDataByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(expensesService.getExpensesByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get3/{uuid}")
    public ResponseEntity<?> getExpensesDataById(@PathVariable("uuid") UUID uuid) {
        try {
            return new ResponseEntity<>(expensesService.getExpensesById(uuid), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get2/{email}/{date}")
    public ResponseEntity<?> getExpensesDataByEmailByDate(@PathVariable("email") String email, @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            return new ResponseEntity<>(expensesService.getExpensesByEmailByDate(email,date), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get4/{email}")
    public ResponseEntity<?> getExpensesDataByEmailByMonth(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(expensesService.getExpensesByEmailByMonth(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get5/{email}/{month}/{year}")
    public ResponseEntity<?> getExpensesDataByEmailByMonthAndYear(@PathVariable("email") String email, @PathVariable("month") Integer month, @PathVariable("year") Integer year) {
        try {
            return new ResponseEntity<>(expensesService.getExpensesByEmailByMonthAndYear(email,month,year), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> deleteExpensesData(@PathVariable("uuid") UUID uuid) {
        try {
            expensesService.deleteExpensesById(uuid);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> updateExpensesData(@PathVariable("uuid") UUID uuid, @RequestBody Expenses expenses) {
        try {
            expensesService.updateExpensesById(uuid,expenses);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
