package com.floreantpos.model;

import com.floreantpos.model.base.BaseScipioInfo;

public class ScipioInfo extends BaseScipioInfo {
	private static final long serialVersionUID = 1L;
	
	private static int TEI_LENGTH = 5;
	private static int PEI_LENGTH = 6;
	private static int PIN_LENGTH = 4;
	
	
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public ScipioInfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ScipioInfo (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/
	
	
	public void setTEI(String tei) throws Exception {
		if (tei.length() != TEI_LENGTH) {
			throw new Exception("TEI must be " + TEI_LENGTH + " digits");
		}
		
		setTEI(Integer.valueOf(tei));
	}
	
	public void setPEI(String pei) throws Exception {
		if (pei.length() != PEI_LENGTH) {
			throw new Exception("PEI must be " + PEI_LENGTH + " digits");
		}
		
		setPEI(Integer.valueOf(pei));
	}
	
	public void setPIN(String pin) throws Exception {
		if (pin.length() != PIN_LENGTH) {
			throw new Exception("PIN must be " + PIN_LENGTH + " digits");
		}
		
		setPIN(Integer.valueOf(pin));
	}
}
