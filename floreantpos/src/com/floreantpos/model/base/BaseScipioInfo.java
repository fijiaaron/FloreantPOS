package com.floreantpos.model.base;

/**
 * This is an object that contains data related to the SCIPIO_INFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SCIPIO_INFO"
 */
public class BaseScipioInfo {
	public static String REF = "ScipioInfo";
	public static String PROP_ID = "id";
	public static String PROP_TEI = "tei";
	public static String PROP_PIN = "pin";
	public static String PROP_TICKET = "ticket";
	
	// constructors
	public BaseScipioInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseScipioInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {
		this.TEI = "";
		this.PIN = "";
	}
	
	private int hashCode = Integer.MIN_VALUE;
	
	// primary key
	private java.lang.Integer id;
	
	// fields
	private java.lang.String TEI;
	private java.lang.String PIN;
	
	// many to one
	private com.floreantpos.model.Ticket ticket;
	
	public static int TEI_LENGTH = 8;
	public static int PIN_LENGTH = 4;
	
	///////////////////////////////////
	// getters and setters 
	///////////////////////////////////
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}
	

	/**
	 * Return the value associated with the column: TEI
	 */
	public java.lang.String getTEI() {
		return TEI;
	}

	/**
	 * Set the value related to the column: TEI
	 * @param TEI the TEI value
	 */
	public void setTEI(java.lang.String tei) throws Exception {
		Integer.parseInt(tei);
		
		if (tei.length() != TEI_LENGTH) {
			throw new Exception("TEI must be " + TEI_LENGTH + " digits");
		}
		
		
		TEI = tei;
	}
	public void setTEI(java.lang.Integer tei) throws Exception {
		setTEI(String.valueOf(tei));
	}
	
	
	/**
	 * Return the value associated with the column: PIN
	 */
	public java.lang.String getPIN() {
		return PIN;
	}

	/**
	 * Set the value related to the column: PIN
	 * @param PIN the PIN value
	 */
	public void setPIN(java.lang.String pin) throws Exception {
		Integer.parseInt(pin);
		
		if (pin.length() != PIN_LENGTH) {
			throw new Exception("PIN must be " + PIN_LENGTH + " digits");
		}
		
		PIN = pin;
	}
	
	public void setPIN(java.lang.Integer pin) throws Exception {
		setPIN(String.valueOf(pin));
	}

	
	/**
	 * Return the value associated with the column: ticket
	 */
	public com.floreantpos.model.Ticket getTicket() {
		return ticket;
	}

	/**
	 * Set the value related to the column: ticket
	 * @param ticket the ticket value
	 */
	public void setTicket(com.floreantpos.model.Ticket ticket) {
		this.ticket = ticket;
	}
}
