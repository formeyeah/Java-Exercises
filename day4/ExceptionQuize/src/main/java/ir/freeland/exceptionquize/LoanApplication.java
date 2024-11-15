package ir.freeland.exceptionquize;
import ir.freeland.exceptionquize.service.LoanService;
import ir.freeland.exceptionquize.service.Exception.LoanNotFound;
import ir.freeland.exceptionquize.service.Exception.UserNotFound;

public class LoanApplication {

    public static void main(String[] args) {
    	
    	try {
		var foundUser=LoanService.findUserLoans("tich Guy");
			System.out.println(foundUser);
		} catch (UserNotFound e) {
			System.err.println("user not found");
			e.printStackTrace();
		}
    	try {
    		var foundUser=LoanService.findUserLoans("Good Pay");
			System.out.println(foundUser);
		} catch (UserNotFound e) {
			System.out.print("user not found");
		}
    	
    	
    	try {
			var isreached=LoanService.isUserLoansDueDateReached("Bad Pay");
			System.out.println(isreached);
			
		} catch (UserNotFound e) {
			System.out.println("user not found");
			e.printStackTrace();
		}
    	catch (LoanNotFound e) {
			System.out.println("laon not found");
			e.printStackTrace();
		}
    
    	
    }

  
}


