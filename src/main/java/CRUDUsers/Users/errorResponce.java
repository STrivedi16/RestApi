package CRUDUsers.Users;

public class Errorresponce {

	private String errorMessage;

	private String errorKey;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorKey = errorMessage;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public Errorresponce(String errorMessage, String errorKey) {
		super();
		this.errorMessage = errorMessage;
		this.errorKey = errorKey;
	}

	public Errorresponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
