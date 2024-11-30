package ir.freeland.logining.service.exception;

public class BrachBuildException extends Exception {
	private static final long serialVersionUID = -6878869107286420150L;

	public BrachBuildException(String message) {
		super(message);
	}

	public BrachBuildException(Throwable cause) {
		super(cause);
	}

	public BrachBuildException(String message, Throwable cause) {
		super(message, cause);
	}

	public BrachBuildException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
