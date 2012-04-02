package scipio.xml.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Util {

	public static int DECIMAL_PLACES = 2;
	public static int ROUNDING = BigDecimal.ROUND_HALF_UP;
	
	public static XMLGregorianCalendar getCalendar(Date date) throws DatatypeConfigurationException {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		XMLGregorianCalendar xcal = null;
		xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		
		return xcal;
	}
	
	// convert to short
	
	public static short int2short(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("value must be positive");
		}
		if (value > Short.MAX_VALUE) {
			throw new IllegalArgumentException("value must be less than " + Short.MAX_VALUE);
		}
		
		return (short)value;
	}
	
	public static short int2ushort(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("value must be positive");
		}
		if (value > Short.MAX_VALUE * 2) {
			throw new IllegalArgumentException("value must be less than " + Short.MAX_VALUE);
		}
		
		return (short)value;
	}
	
	// convert to decimal
	
	public static BigDecimal decimal(int value) {
		return int2decimal(value);
	}
	
	public static BigDecimal decimal(double value) {
		return double2decimal(value);
	}
	
	public static BigDecimal double2decimal(double value) {
		return new BigDecimal(value).setScale(DECIMAL_PLACES, ROUNDING);
	}
	
	public static BigDecimal int2decimal(int value) {
		return new BigDecimal(value).setScale(DECIMAL_PLACES, ROUNDING);
	}
	
	public static double decimal2double(BigDecimal value) {
		return value.setScale(DECIMAL_PLACES, ROUNDING).doubleValue();
	}
	
	public static double decimal2int(BigDecimal value) {
		return value.setScale(DECIMAL_PLACES, ROUNDING).intValue();
	}

	// round
	
	public static double round(double value) {
		return round(value, DECIMAL_PLACES);
	}

	public static double round(BigDecimal value) {
		return round(value, DECIMAL_PLACES);
	}
	
	public static double round(double value, int decimalPlaces) {
		return round(double2decimal(value), decimalPlaces);
	}
	
	public static double round(BigDecimal value, int decimalPlaces) {
		return value.setScale(decimalPlaces, ROUNDING).doubleValue();
	}

	// add
	
	public static BigDecimal add(int a, BigDecimal b) {
		return b.add(int2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(BigDecimal a, int b) {
		return a.add(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(double a, BigDecimal b) {
		return b.add(double2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(BigDecimal a, double b) {
		return a.add(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(int a, double b) {
		return add(a, double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(double a, int b) {
		return double2decimal(a).add(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(int a, int b) {
		return int2decimal(a).add(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(double a, double b) {
		return double2decimal(a).add(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal add(BigDecimal a, BigDecimal b) {
		return a.add(b).setScale(DECIMAL_PLACES);
	}
	
	
	// subtract
	
	public static BigDecimal subtract(int a, BigDecimal b) {
		return b.subtract(int2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(BigDecimal a, int b) {
		return a.subtract(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(double a, BigDecimal b) {
		return b.subtract(double2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(BigDecimal a, double b) {
		return a.subtract(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(int a, double b) {
		return subtract(a, double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(double a, int b) {
		return double2decimal(a).subtract(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(int a, int b) {
		return int2decimal(a).subtract(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(double a, double b) {
		return double2decimal(a).subtract(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
		return a.subtract(b).setScale(DECIMAL_PLACES);
	}
	
	// multiply
	
	public static BigDecimal multiply(int a, BigDecimal b) {
		return b.multiply(int2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(BigDecimal a, int b) {
		return a.multiply(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(double a, BigDecimal b) {
		return b.multiply(double2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(BigDecimal a, double b) {
		return a.multiply(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(int a, double b) {
		return multiply(a, double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(double a, int b) {
		return double2decimal(a).multiply(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(int a, int b) {
		return int2decimal(a).multiply(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(double a, double b) {
		return double2decimal(a).multiply(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		return a.multiply(b).setScale(DECIMAL_PLACES);
	}
	
	// divide
	
	
	public static BigDecimal divide(int a, BigDecimal b) {
		return b.divide(int2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(BigDecimal a, int b) {
		return a.divide(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(double a, BigDecimal b) {
		return b.divide(double2decimal(a)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(BigDecimal a, double b) {
		return a.divide(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(int a, double b) {
		return divide(a, double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(double a, int b) {
		return double2decimal(a).divide(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(int a, int b) {
		return int2decimal(a).divide(int2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(double a, double b) {
		return double2decimal(a).divide(double2decimal(b)).setScale(DECIMAL_PLACES);
	}
	
	public static BigDecimal divide(BigDecimal a, BigDecimal b) {
		return a.divide(b).setScale(DECIMAL_PLACES);
	}

}
