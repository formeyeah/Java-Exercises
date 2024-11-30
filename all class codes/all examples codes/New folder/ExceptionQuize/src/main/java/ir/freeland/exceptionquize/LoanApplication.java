package ir.freeland.exceptionquize;

import ir.freeland.exceptionquize.service.LoanService;

public class LoanApplication {

    public static void main(String[] args) {
    	LoanService.findUserLoans("Rich Guy");
    	LoanService.isUserLoansDueDateReached("Bad Pay");
    
    	
    }

  
}


