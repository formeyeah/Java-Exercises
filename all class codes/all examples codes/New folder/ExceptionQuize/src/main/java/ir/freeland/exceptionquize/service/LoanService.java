package ir.freeland.exceptionquize.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ir.freeland.exceptionquize.model.Loan;
import ir.freeland.exceptionquize.model.LoanType;
import ir.freeland.exceptionquize.model.User;

public class LoanService {
	private static List<User> users;
	static {
        Loan loan1 = new Loan("Car Loan", LocalDateTime.of(2027, 5, 1, 0, 0), 15000, LoanType.CAR);
        Loan loan2 = new Loan("Home Loan", LocalDateTime.of(2028, 10, 15, 0, 0), 250000, LoanType.HOUSE);
        Loan loan3 = new Loan("Wedding Loan", LocalDateTime.of(2022, 12, 20, 0, 0), 20000, LoanType.MARIAGE);
        Loan loan4 = new Loan("Repair Loan", LocalDateTime.of(2023, 8, 30, 0, 0), 5000, LoanType.REPAIR);

        // Create sample users with loans
        User user1 = new User("Good Pay", List.of(loan1, loan2));
        User user2 = new User("Bad Pay", List.of(loan3, loan4));
        User user3 = new User("Rich Guy", new ArrayList<>()); // No loans
        
        users= List.of(user1,user2,user3);
	}
	
	public static List<Loan> findUserLoans(String userName)  {
		return null;
	}
	
	public static boolean isUserLoansDueDateReached(String userName) {
		return true;
	}
	
}
