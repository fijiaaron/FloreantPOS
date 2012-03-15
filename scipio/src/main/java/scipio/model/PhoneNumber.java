package scipio.model;

public class PhoneNumber {
	private String phoneNumber;

	public PhoneNumber() {}
	
	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
