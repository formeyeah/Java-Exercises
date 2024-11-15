package ir.freeland.exceptionquize.service;

import java.io.FileNotFoundException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.UnsupportedLookAndFeelException;

import ir.freeland.exceptionquize.model.Loan;
import ir.freeland.exceptionquize.model.LoanType;
import ir.freeland.exceptionquize.model.User;
import ir.freeland.exceptionquize.service.Exception.LoanNotFound;
import ir.freeland.exceptionquize.service.Exception.UserNotFound;

public class LoanService {
	private static List<User> users;
	static {
        Loan loan1 = new Loan("Car Loan", LocalDateTime.of(2027, 5, 1, 0, 0), 15000, LoanType.CAR);
        Loan loan2 = new Loan("Home Loan", LocalDateTime.of(2028, 10, 15, 0, 0), 250000, LoanType.HOUSE);
        Loan loan3 = new Loan("Wedding Loan", LocalDateTime.of(2022, 12, 20, 0, 0), 20000, LoanType.MARIAGE);
        Loan loan4 = new Loan("Repair Loan", LocalDateTime.of(2023, 8, 30, 0, 0), 5000, LoanType.REPAIR);
        Loan laon5= new Loan("wedding loan", LocalDateTime.of(2012, 4,1, 0,0),4000,LoanType.CAR);
        // Create sample users with loans
        User user1 = new User("Good Pay", List.of(loan1, loan2));
        User user2 = new User("Bad Pay", List.of(loan3, loan4));
        User user3 = new User("Rich Guy", new ArrayList<>()); // No loans
        
        users= List.of(user1,user2,user3);
	}
	
	public static List<Loan> findUserLoans(String userName) throws UserNotFound {
	
		List<User> userfound=users.stream().filter(t -> t.username().equals(userName)).collect(Collectors.toList());
			
		if (userfound.size() !=1) {
			throw new UserNotFound("file does not exist");
		}
			
		return userfound.get(0).loans();
	}
	
	public static boolean isUserLoansDueDateReached(String userName) throws UserNotFound,LoanNotFound {
		
		User user=users.stream().filter(t -> t.username().equals(userName))
		.findFirst()
		.orElseThrow(()-> new UserNotFound("user not found"));
		if (user.loans().size()==0) {
			throw new LoanNotFound("laon not found");
			
		}
		return user.loans().stream()
				.anyMatch(t -> t.dueDate().isBefore(LocalDateTime.now()));
		
	}
	
}
