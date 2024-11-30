package ir.freeland.jsonquize.service.exception;

public class EmployeeServiceException extends Exception {
	private static final long serialVersionUID = 6297258431482127104L;
	
	public EmployeeServiceException(String msg,Exception e) {
		super(msg, e);
	}

}
