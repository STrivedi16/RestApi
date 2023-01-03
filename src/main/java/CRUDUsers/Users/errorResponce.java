package CRUDUsers.Users;

public class errorResponce {

	private String ErrorMessage;

	private String ErrorKey;

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getErrorKey() {
		return ErrorKey;
	}

	public void setErrorKey(String errorKey) {
		ErrorKey = errorKey;
	}

	public errorResponce(String errorMessage, String errorKey) {
		super();
		ErrorMessage = errorMessage;
		ErrorKey = errorKey;
	}

	public errorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
