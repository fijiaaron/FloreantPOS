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
	public static String PROP_PEI = "pei";
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

	protected void initialize () {}
	
	private int hashCode = Integer.MIN_VALUE;
	
	// primary key
	private java.lang.Integer id;
	
	// fields
	private java.lang.Integer PEI;
	private java.lang.Integer TEI;
	private java.lang.Integer PIN;
	
	// many to one
	private com.floreantpos.model.Ticket ticket;
	
	
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
	 * Return the value associated with the column: PEI
	 */
	public java.lang.Integer getPEI() {
		return PEI;
	}

	/**
	 * Set the value related to the column: PEI
	 * @param PEI the PEI value
	 */
	public void setPEI(java.lang.Integer pei) {
		PEI = pei;
	}

	/**
	 * Return the value associated with the column: TEI
	 */
	public java.lang.Integer getTEI() {
		return TEI;
	}

	/**
	 * Set the value related to the column: TEI
	 * @param TEI the TEI value
	 */
	public void setTEI(java.lang.Integer tei) {
		TEI = tei;
	}

	/**
	 * Return the value associated with the column: PIN
	 */
	public java.lang.Integer getPIN() {
		return PIN;
	}

	/**
	 * Set the value related to the column: PIN
	 * @param PIN the PIN value
	 */
	public void setPIN(java.lang.Integer pin) {
		PIN = pin;
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
