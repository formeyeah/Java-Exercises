package ir.freeland.exceptionquize.model;

import java.time.LocalDateTime;

public record Loan(String loanName, LocalDateTime dueDate, int amount, LoanType type) {

}
