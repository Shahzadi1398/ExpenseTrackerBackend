package ExpensesTracker.Controller;

import ExpensesTracker.Modal.ResponseMessage;
import ExpensesTracker.Modal.SignUp;
import ExpensesTracker.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Developer : Shahzadi Parveen
 * @Project-Name : ExpensesTracker
 * @Mailto : shahzadiparveen@cdac.in
 * @Created : 04-03-2024
 * @Weekday : Monday
 **/

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSignUpData(@RequestBody SignUp signUp) {
        try {
             signUpService.saveSignUp(signUp);
            return new ResponseEntity<>(new ResponseMessage("1", "Record save Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getData")
    public ResponseEntity<?> getSignUpData() {
        try {
            return new ResponseEntity<>(signUpService.getDataSignUp(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/{email}/{password}")
    public ResponseEntity<?> getSignUpDataWhenLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
        try {
            List<SignUp> signUpList = signUpService.getSingUpWhenLogin(email, password);
            if (signUpList.isEmpty()) {
                return new ResponseEntity<>(new ResponseMessage("0", "Record Not Present "), HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>(signUpList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Error: " + e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }
    }



    @PutMapping("/update/{email}/{password}")
    public ResponseEntity<?> saveSignUpData(@PathVariable("email") String email, @PathVariable("password") String password) {
        try {
            signUpService.updateSingUpWhenLogout(email, password);
            return new ResponseEntity<>(new ResponseMessage("1", "Record update Successfully"),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseMessage("0", "Record not saved: " + e.getLocalizedMessage() + " / " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
