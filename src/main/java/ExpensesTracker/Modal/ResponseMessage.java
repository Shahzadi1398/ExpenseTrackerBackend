package ExpensesTracker.Modal;

/*
 * @Author : Shahzadi Parveen
 * @Project Name : afcsdashboard
 * @Created : 23-01-2023
 * @Mailto : shahzadicdac13@gmail.com
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

    private String status;
    private Object data;
}
