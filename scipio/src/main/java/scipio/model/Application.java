package scipio.model;

public class Application {
	String appId;
	String username;
	String smi;
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String id) {
		this.appId = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSmi() {
		return smi;
	}
	public void setSmi(String smi) {
		this.smi = smi;
	}
}
