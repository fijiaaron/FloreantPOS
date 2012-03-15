package scipio.model;

public class Merchant {
	private int id;
	private String type;
	private String name;
	private int storeNumber;
	private int registerNumber;
	private PhoneNumber telephone;
	private Address address;
	
	///////////////////////////////////
	// Constructors
	///////////////////////////////////

	public Merchant() {}
	
	public Merchant(int id) {
		//TODO: fetch from db
	}
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}
	public int getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}
	public PhoneNumber getTelephone() {
		return telephone;
	}
	public void setTelephone(PhoneNumber telephone) {
		this.telephone = telephone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
