package CRUDUsers.Users;

public class SuccessResponce {

	private String successmessage;

	private String successKey;

	private Object object;

	public SuccessResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuccessResponce(String successmessage, String successKey, Object object) {
		super();
		successmessage = successmessage;
		this.successKey = successKey;
		this.object = object;
	}

	public String getSuccessmessage() {
		return successmessage;
	}

	public void setSuccessmessage(String successmessage) {
		successmessage = successmessage;
	}

	public String getSuccessKey() {
		return successKey;
	}

	public void setSuccessKey(String successKey) {
		this.successKey = successKey;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
