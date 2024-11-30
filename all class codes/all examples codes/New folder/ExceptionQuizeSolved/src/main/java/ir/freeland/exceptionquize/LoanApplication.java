package ir.freeland.exceptionquize;

import ir.freeland.exceptionquize.service.LoanService;
import ir.freeland.exceptionquize.service.exceptions.NoLoanForUserExcepteion;
import ir.freeland.exceptionquize.service.exceptions.UserNotFoundExcepteion;

public class LoanApplication {

    public static void main(String[] args) {
    	try {
			var loans = LoanService.findUserLoans("Rich Guy");
			System.out.println( loans );
		} catch (UserNotFoundExcepteion e) {
			System.out.println("Coud not find user, check and try again");
		}
    	System.out.println( "--------------------------------");
    	try {
			var hasLoans = LoanService.isUserLoansDueDateReached("Bad Pay");
			System.out.println( "User has due dated loans: " + hasLoans);
		} catch (UserNotFoundExcepteion e) {
			System.out.println("Coud not find user, check and try again");
		} catch (NoLoanForUserExcepteion e) {
			System.out.println("The user has no loans at all");
		}
    	System.out.println( "--------------------------------");
    	try {
			var hasLoans = LoanService.isUserLoansDueDateReached("Bad Pay");
			System.out.println( "(Multi Catch)User has due dated loans: " + hasLoans);
		} catch (UserNotFoundExcepteion | NoLoanForUserExcepteion e) {
			System.out.println("Coud not find user, or he has no loans");
		}
    	
    }

  
}


