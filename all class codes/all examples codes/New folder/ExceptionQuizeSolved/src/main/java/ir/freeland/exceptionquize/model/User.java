package ir.freeland.exceptionquize.model;

import java.util.List;

public record User(String username, List<Loan> loans) {	
	
}
