package scipio.xml.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="application">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="appId" type="http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="merchant">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="smi" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="address">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="address3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="storeNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="terminal">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="consumer">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tei" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="transaction">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="activated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="closed" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                   &lt;element name="tableNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="numberofGuests" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                   &lt;element name="serverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="items">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="item" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                       &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                       &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                       &lt;element name="coupon">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="subtotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="discounts">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="rewards" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="coupons">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="coupon" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                                                 &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                                                 &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="subtotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="salestax">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="taxableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="tip" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="amountPaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="payment">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="amountCharged" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                   &lt;element name="method" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="card">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="cardHolder">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "application",
    "pos",
    "merchant",
    "terminal",
    "consumer",
    "transaction",
    "payment"
})
@XmlRootElement(name = "receipt")
public class Receipt {
	private static Logger logger = Logger.getLogger(Receipt.class);
	
	public static final int DECIMAL_PLACES = 2;
	
    @XmlElement(required = true)
    protected Receipt.Application application;
    @XmlElement(required = true)
    protected Receipt.Pos pos;
    @XmlElement(required = true)
    protected Receipt.Merchant merchant;
    @XmlElement(required = true)
    protected Receipt.Terminal terminal;
    @XmlElement(required = true)
    protected Receipt.Consumer consumer;
    @XmlElement(required = true)
    protected Receipt.Transaction transaction;
    @XmlElement(required = true)
    protected Receipt.Payment payment;

    /**
     * Gets the value of the application property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Application }
     *     
     */
    public Receipt.Application getApplication() {
        return application;
    }

    /**
     * Sets the value of the application property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Application }
     *     
     */
    public void setApplication(Receipt.Application value) {
        this.application = value;
    }

    /**
     * Gets the value of the pos property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Pos }
     *     
     */
    public Receipt.Pos getPos() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Pos }
     *     
     */
    public void setPos(Receipt.Pos value) {
        this.pos = value;
    }

    /**
     * Gets the value of the merchant property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Merchant }
     *     
     */
    public Receipt.Merchant getMerchant() {
        return merchant;
    }

    /**
     * Sets the value of the merchant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Merchant }
     *     
     */
    public void setMerchant(Receipt.Merchant value) {
        this.merchant = value;
    }

    /**
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Terminal }
     *     
     */
    public Receipt.Terminal getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Terminal }
     *     
     */
    public void setTerminal(Receipt.Terminal value) {
        this.terminal = value;
    }

    /**
     * Gets the value of the consumer property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Consumer }
     *     
     */
    public Receipt.Consumer getConsumer() {
        return consumer;
    }

    /**
     * Sets the value of the consumer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Consumer }
     *     
     */
    public void setConsumer(Receipt.Consumer value) {
        this.consumer = value;
    }

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Transaction }
     *     
     */
    public Receipt.Transaction getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Transaction }
     *     
     */
    public void setTransaction(Receipt.Transaction value) {
        this.transaction = value;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link Receipt.Payment }
     *     
     */
    public Receipt.Payment getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receipt.Payment }
     *     
     */
    public void setPayment(Receipt.Payment value) {
        this.payment = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "appId"
    })
    public static class Application {

    	@XmlSchemaType(name = "unsignedInt")
        protected String appId;

    	// Constructors
    	public Application() {}
    	
    	public Application(String appId) { setAppId(appId); }
    	
        /**
         * Gets the value of the appId property.
         * 
         */
        public String getAppId() {
            return appId;
        }

        /**
         * Sets the value of the appId property.
         * 
         */
		public void setAppId(String value) {
			this.appId = value;
		}

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tei" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "pin",
        "tei"
    })
    public static class Consumer {
        @XmlElement
        protected int pin;
        @XmlElement
        protected long tei;
		  
        // Constructors
        public Consumer() {}
        
        public Consumer(int pin, int tei) {  
        	setPin(pin); 
        	setTei(tei); 
        } 
        public Consumer(String pin, String tei) { 
        	setPin(pin); 
        	setTei(tei); 
        }
		
        /**
         * Gets the value of the tei property.
         * 
         */
        public long getTei() {
            return tei;
        }

        /**
         * Sets the value of the tei property.
         * 
         */
        public void setTei(long value) {
            this.tei = value;
        }
        public void setTei(String value) {
            try {
				setTei(Integer.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid TEI: " + value));
			} catch (Exception e) {
				logger.warn(("wrong TEI length"));
				logger.warn(e.getMessage());
			}
        }

        /**
         * Gets the value of the pin property.
         * 
         */
        public int getPin() {
            return pin;
        }

        /**
         * Sets the value of the pin property.
         * 
         */
        public void setPin(int value) {
            this.pin = value;
        }
        public void setPin(String value) {
			try {
				setPin(Integer.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid PIN: " + value));
			} catch (Exception e) {
				logger.warn(("wrong PIN length"));
				logger.warn(e.getMessage());
			}
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="smi" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="address">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="address3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="storeNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "smi",
        "username",
        "address",
        "id",
        "storeNumber",
        "telephone",
        "type"
    })
    public static class Merchant {

        @XmlElement(required = true)
        protected int smi;
        @XmlElement(required = true)
        protected String username;
        @XmlElement(required = true)
        protected Receipt.Merchant.Address address;
        @XmlSchemaType(name = "unsignedInt")
        protected long id;
        @XmlSchemaType(name = "unsignedInt")
        protected long storeNumber;
        @XmlElement(required = true)
        protected String telephone;
        @XmlElement(required = true)
        protected String type;

        // Constructors
        public Merchant() {}
        public Merchant(long id) { setId(id); }
        public Merchant(int id) { setId(id); }
        public Merchant(String id) { setId(id); }
        
        /**
         * Gets the value of the smi property.
         * 
         * @return
         *     possible object is
         *     {@link int }
         *     
         */
        public int getSmi() {
            return smi;
        }

        /**
         * Sets the value of the smi property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSmi(int value) {
            this.smi = value;
        }
		public void setSmi(String value) {
			try {
				if (value.length() != 6) {
					throw new IllegalArgumentException("SMI must be 6 digits");
				}
				setSmi(Integer.valueOf(value));
			} catch (NumberFormatException ex) {
				logger.warn(ex.getMessage());
				logger.info(ex.getStackTrace().toString());
			} catch (IllegalArgumentException ex) {
				logger.warn(ex.getMessage());
				logger.info(ex.getStackTrace().toString());
			}
        }
 
        /**
         * Gets the value of the username property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUsername() {
            return username;
        }

        /**
         * Sets the value of the username property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUsername(String value) {
            this.username = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Merchant.Address }
         *     
         */
        public Receipt.Merchant.Address getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Merchant.Address }
         *     
         */
        public void setAddress(Receipt.Merchant.Address value) {
            this.address = value;
        }

        /**
         * Gets the value of the id property.
         * 
         */
        public long getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(long value) {
            this.id = value;
        }
        public void setId(int value) {
        	this.id = value;
        }
        public void setId(String value) {
			try {
				setId(Long.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid merchant id: " + value));
			}
        }

        /**
         * Gets the value of the storeNumber property.
         * 
         */
        public long getStoreNumber() {
            return storeNumber;
        }

        /**
         * Sets the value of the storeNumber property.
         * 
         */
        public void setStoreNumber(long value) {
            this.storeNumber = value;
        }
		public void setStoreNumber(String value) {
			try {
				setStoreNumber(Long.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid storeNumber: " + value));
			}
		}

        /**
         * Gets the value of the telephone property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTelephone() {
            return telephone;
        }

        /**
         * Sets the value of the telephone property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTelephone(String value) {
            this.telephone = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="address1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="address2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="address3" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "address1",
            "address2",
            "address3"
        })
        public static class Address {

            @XmlElement(required = true)
            protected String address1;
            @XmlElement(required = true)
            protected String address2;
            @XmlElement(required = true)
            protected String address3;

            // Constructors 
            public Address() {}
            public Address(String address1, String address2, String address3) {
            	this.address1 = address1;
            	this.address2 = address2;
            	this.address3 = address3;
            }
            
            /**
             * Gets the value of the address1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress1() {
                return address1;
            }

            /**
             * Sets the value of the address1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress1(String value) {
                this.address1 = value;
            }

            /**
             * Gets the value of the address2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress2() {
                return address2;
            }

            /**
             * Sets the value of the address2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress2(String value) {
                this.address2 = value;
            }

            /**
             * Gets the value of the address3 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress3() {
                return address3;
            }

            /**
             * Sets the value of the address3 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress3(String value) {
                this.address3 = value;
            }

        }



    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="amountCharged" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="method" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="card">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="cardHolder">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="authorizationCode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "grandTotal",
        "amountCharged",
        "method",
        "card",
        "authorizationCode"
    })
    public static class Payment {

        @XmlElement(required = true)
        protected BigDecimal grandTotal;
        @XmlElement(required = true)
        protected BigDecimal amountCharged;
        @XmlElement(required = true)
        protected String method;
        @XmlElement(required = true)
        protected Receipt.Payment.Card card;
        @XmlSchemaType(name = "unsignedInt")
        protected long authorizationCode;

        // constructors
        public Payment() {}
        public Payment(String method) { setMethod(method); }
        public Payment(String method, Card card) { 
        	setMethod(method); 
        	setCard(card);
        }
        public Payment(String method, Card card, double amountPaid, double amountDue) { 
        	setMethod(method); 
        	setCard(card);
        	setAmountCharged(amountPaid);
        	setGrandTotal(amountDue);
        }
        public Payment(String method, Card card, double amountPaid, double amountDue, long authCode) { 
        	setMethod(method); 
        	setCard(card);
        	setAmountCharged(amountPaid);
        	setGrandTotal(amountDue);
        	setAuthorizationCode(authCode);
        }
        
        /**
         * Gets the value of the grandTotal property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGrandTotal() {
            return grandTotal;
        }

        /**
         * Sets the value of the grandTotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGrandTotal(BigDecimal value) {
            this.grandTotal = value;
        }
        public void setGrandTotal(double value) {
            setGrandTotal(Util.double2decimal(value));
        }

        /**
         * Gets the value of the amountCharged property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmountCharged() {
            return amountCharged;
        }

        /**
         * Sets the value of the amountCharged property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmountCharged(BigDecimal value) {
            this.amountCharged = value;
        }
        public void setAmountCharged(double value) {
            setAmountCharged(Util.double2decimal(value));
        }

        /**
         * Gets the value of the method property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMethod() {
            return method;
        }

        /**
         * Sets the value of the method property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMethod(String value) {
            this.method = value;
        }

        /**
         * Gets the value of the card property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Payment.Card }
         *     
         */
        public Receipt.Payment.Card getCard() {
            return card;
        }

        /**
         * Sets the value of the card property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Payment.Card }
         *     
         */
        public void setCard(Receipt.Payment.Card value) {
            this.card = value;
        }

        /**
         * Gets the value of the authorizationCode property.
         * 
         */
        public long getAuthorizationCode() {
            return authorizationCode;
        }

        /**
         * Sets the value of the authorizationCode property.
         * 
         */
        public void setAuthorizationCode(long value) {
            this.authorizationCode = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="cardHolder">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="expiration" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cardHolder",
            "expiration",
            "number",
            "type"
        })
        public static class Card {

            @XmlElement(required = true)
            protected Receipt.Payment.Card.CardHolder cardHolder;
            @XmlElement(required = true)
            protected String expiration;
            @XmlSchemaType(name = "unsignedShort")
            protected int number;
            @XmlElement(required = true)
            protected String type;

            // constructors
            public Card() {}
            public Card(String type, String number, String exp, String holder) {
				setType(type);
				setNumber(number);
				setExpiration(exp);
				setCardHolder(holder);
			}

			/**
             * Gets the value of the cardHolder property.
             * 
             * @return
             *     possible object is
             *     {@link Receipt.Payment.Card.CardHolder }
             *     
             */
            public Receipt.Payment.Card.CardHolder getCardHolder() {
                return cardHolder;
            }

            /**
             * Sets the value of the cardHolder property.
             * 
             * @param value
             *     allowed object is
             *     {@link Receipt.Payment.Card.CardHolder }
             *     
             */
            public void setCardHolder(Receipt.Payment.Card.CardHolder value) {
                this.cardHolder = value;
            }
            public void setCardHolder(String firstName, String lastName) {
            	this.cardHolder = new Receipt.Payment.Card.CardHolder(firstName, lastName);
            }
            public void setCardHolder(String name) {
				if (name!= null) {
					String[] names = name.split("\\s+", 2);
				
					if (names.length < 2) {
						throw new IllegalArgumentException("must have first and last name");
					}

					setCardHolder(names[0].trim(), names[1].trim());
				}
            }

            /**
             * Gets the value of the expiration property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getExpiration() {
                return expiration;
            }

            /**
             * Sets the value of the expiration property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setExpiration(String value) {
                this.expiration = value;
            }

            /**
             * Gets the value of the number property.
             * 
             */
            public int getNumber() {
                return number;
            }

            /**
             * Sets the value of the number property.
             * 
             */
            public void setNumber(int value) {
                this.number = value;
            }
            public void setNumber(String value) {
				try {
					setNumber(Integer.valueOf(value));
				} catch (NumberFormatException e) { 
					logger.warn(("invalid credit card number: " + value));
				}
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "firstName",
                "lastName"
            })
            public static class CardHolder {

                @XmlElement(required = true)
                protected String firstName;
                @XmlElement(required = true)
                protected String lastName;

                // constructors
                public CardHolder() {}
                public CardHolder(String firstName, String lastName) {
                	setFirstName(firstName);
                	setLastName(lastName);
                }
                
                /**
                 * Gets the value of the firstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFirstName() {
                    return firstName;
                }

                /**
                 * Sets the value of the firstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFirstName(String value) {
                    this.firstName = value;
                }

                /**
                 * Gets the value of the lastName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLastName() {
                    return lastName;
                }

                /**
                 * Sets the value of the lastName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLastName(String value) {
                    this.lastName = value;
                }

            }

        }
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "version"
    })
    public static class Pos {

        @XmlElement(required = true)
        protected String name;
        @XmlElement(required = true)
        protected String version;

        // Constructors
        public Pos() {}
        public Pos(String name, String version) {
        	setName(name);
        	setVersion(version);
        }
        
		/**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "id",
        "name"
    })
    public static class Terminal {

        @XmlSchemaType(name = "unsignedInt")
        protected long id;
        @XmlElement(required = true)
        protected String name;

        // Constructors
        public Terminal() {}
        public Terminal(long id) { setId(id); }
        public Terminal(String id) { setId(id); }
        public Terminal(long id, String name) { setId(id); setName(name);}
        public Terminal(String id, String name) { setId(id); setName(name); }
        
        /**
         * Gets the value of the id property.
         * 
         */
        public long getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(long value) {
            this.id = value;
        }
		public void setId(String value) {
			try {
				setId(Long.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid terminal id: " + value));
			}
		}
		

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="activated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="closed">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}time"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *         &lt;element name="tableNumber" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="numberofGuests" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *         &lt;element name="serverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="items">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="item" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                             &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                             &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="coupon">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="subtotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="discounts">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rewards" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="coupons">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="coupon" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
     *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="subtotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="salestax">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="taxableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="tip" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="grandTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="amountPaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "activated",
        "created",
        "closed",
        "transactionId",
        "tableNumber",
        "numberofGuests",
        "serverName",
        "items",
        "discounts",
        "subtotal",
        "discount",
        "total",
        "salestax",
        "tax",
        "tip",
        "grandTotal",
        "status",
        "amountPaid"
    })
    public static class Transaction {

    	public static class Status {
    		public static final String COMP = "COMP/FREE";
			public static String PAID = "PAID";
    		public static String NOT_PAID = "NOT PAID";
    		public static String PARTIALLY_PAID = "PARTIALLY PAID";
    	}

		// constructors
    	public Transaction() {}
    	public Transaction(int id) {
			setTransactionId(id);
    	}
    	public Transaction(long id) {
    		setTransactionId(id);
    	}
    	public Transaction(String id) {
			setTransactionId(transactionId);
    	}
    	
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar activated;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar created;
        @XmlElement(required = true)
        protected Receipt.Transaction.Closed closed;
        @XmlSchemaType(name = "unsignedInt")
        protected long transactionId;
        @XmlSchemaType(name = "unsignedByte")
        protected short tableNumber;
        @XmlSchemaType(name = "unsignedByte")
        protected short numberofGuests;
        @XmlElement(required = true)
        protected String serverName;
        @XmlElement(required = true)
        protected Receipt.Transaction.Items items;
        @XmlElement(required = true)
        protected Receipt.Transaction.Discounts discounts;
        @XmlElement(required = true)
        protected BigDecimal subtotal;
        @XmlElement(required = true)
        protected BigDecimal discount;
        @XmlElement(required = true)
        protected BigDecimal total;
        @XmlElement(required = true)
        protected Receipt.Transaction.Salestax salestax;
        @XmlElement(required = true)
        protected BigDecimal tax;
        @XmlElement(required = true)
        protected BigDecimal tip;
        @XmlElement(required = true)
        protected BigDecimal grandTotal;
        @XmlElement(required = true)
        protected String status;
        @XmlElement(required = true)
        protected BigDecimal amountPaid;

        /**
         * Gets the value of the activated property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getActivated() {
            return activated;
        }

        /**
         * Sets the value of the activated property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setActivated(XMLGregorianCalendar value) {
            this.activated = value;
        }
		public void setActivated(Date date) {
			try {
				setActivated(Util.getCalendar(date));
			} catch (DatatypeConfigurationException e) {
				logger.warn("cannot set transaction activated date" + date);
				// activated date will not be set
			}
		}

        /**
         * Gets the value of the created property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getCreated() {
            return created;
        }

        /**
         * Sets the value of the created property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setCreated(XMLGregorianCalendar value) {
            this.created = value;
        }
		public void setCreated(Date date) {
			try {
				setCreated(Util.getCalendar(date));
			} catch (DatatypeConfigurationException e) {
				logger.warn("cannot set transaction created date" + date);
				// created date will not be set
			}
		}

        /**
         * Gets the value of the closed property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Transaction.Closed }
         *     
         */
        public Receipt.Transaction.Closed getClosed() {
            return closed;
        }

        /**
         * Sets the value of the closed property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Transaction.Closed }
         *     
         */
        public void setClosed(Receipt.Transaction.Closed value) {
            this.closed = value;
        }

        public void setClosed(Date date) {
        	this.closed = new Closed(date);
		}
        

        /**
         * Gets the value of the transactionId property.
         * 
         */
        public long getTransactionId() {
            return transactionId;
        }

        /**
         * Sets the value of the transactionId property.
         * 
         */
        public void setTransactionId(long value) {
            this.transactionId = value;
        }
		public void setTransactionId(String value) {
			try {
				setTransactionId(Long.valueOf(value));
			} catch (NumberFormatException e) { 
				logger.warn(("invalid transaction id: " + value));
			}
		}
		
        /**
         * Gets the value of the tableNumber property.
         * 
         */
        public short getTableNumber() {
            return tableNumber;
        }

        /**
         * Sets the value of the tableNumber property.
         * 
         */
        public void setTableNumber(short value) {
            this.tableNumber = value;
        }
        public void setTableNumber(int value) {
         	setTableNumber(Util.int2ushort(value));
        }

        /**
         * Gets the value of the numberofGuests property.
         * 
         */
        public short getNumberofGuests() {
            return numberofGuests;
        }

        /**
         * Sets the value of the numberofGuests property.
         * 
         */
        public void setNumberofGuests(short value) {
            this.numberofGuests = value;
        }
        public void setNumberofGuests(int value) {
            setNumberofGuests(Util.int2ushort(value));
        }

        /**
         * Gets the value of the serverName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServerName() {
            return serverName;
        }

        /**
         * Sets the value of the serverName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServerName(String value) {
            this.serverName = value;
        }

        /**
         * Gets the value of the items property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Transaction.Items }
         *     
         */
        public Receipt.Transaction.Items getItems() {
        	if (items == null) {
        		items = new Items();
        	}
            return items;
        }

        /**
         * Sets the value of the items property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Transaction.Items }
         *     
         */
        public void setItems(Receipt.Transaction.Items value) {
            this.items = value;
        }

        /**
         * Gets the value of the discounts property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Transaction.Discounts }
         *     
         */
        public Receipt.Transaction.Discounts getDiscounts() {
        	if (discounts == null) {
        		discounts = new Discounts();
        	}
            return discounts;
        }

        /**
         * Sets the value of the discounts property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Transaction.Discounts }
         *     
         */
        public void setDiscounts(Receipt.Transaction.Discounts value) {
            this.discounts = value;
        }

        /**
         * Gets the value of the subtotal property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getSubtotal() {
        	if (subtotal == null) {
	        	subtotal = new BigDecimal(0.00);
	        	
	        	for (Items.Item item : getItems().getItem()) {
	        		subtotal = subtotal.add(item.getTotal());
	        	}
        	}
        	
        	return subtotal.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the subtotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setSubtotal(BigDecimal value) {
            this.subtotal = value;
        }
        public void setSubTotal(double value) {
        	setSubtotal(Util.double2decimal(value));
        }

        /**
         * Gets the value of the discount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getDiscount() {
        	if (discount == null) {
        		discount = discounts.getValue();
        	}
        	
            return discount.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the discount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setDiscount(BigDecimal value) {
            this.discount = value;
        }
        public void setDiscount(double value) {
        	setDiscount(Util.double2decimal(value));
        }
        

        /**
         * Gets the value of the total property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTotal() {
        	if (total == null) {
        		total = getSubtotal().subtract(getDiscount());
        	}
        	
            return total.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the total property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTotal(BigDecimal value) {
            this.total = value;
        }
        public void setTotal(double value) {
        	setTotal(Util.double2decimal(value));
        }

        /**
         * Gets the value of the salestax property.
         * 
         * @return
         *     possible object is
         *     {@link Receipt.Transaction.Salestax }
         *     
         */
        public Receipt.Transaction.Salestax getSalestax() {
            return salestax;
        }

        /**
         * Sets the value of the salestax property.
         * 
         * @param value
         *     allowed object is
         *     {@link Receipt.Transaction.Salestax }
         *     
         */
        public void setSalestax(Receipt.Transaction.Salestax value) {
            this.salestax = value;
        }

        /**
         * Gets the value of the tax property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTax() {
        	if (tax == null) {
        		tax = getSalestax().getTotal();
        	}
        	
            return tax.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the tax property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTax(BigDecimal value) {
            this.tax = value;
        }
        public void setTax(double value) {
        	setTax(Util.double2decimal(value));
        }

        /**
         * Gets the value of the tip property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getTip() {
        	if (tip == null) {
        		tip = Util.decimal(0.00);
        	}
        	
            return tip.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the tip property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setTip(BigDecimal value) {
            this.tip = value;
        }
        public void setTip(double value) {
        	setTip(Util.double2decimal(value));
        }

        /**
         * Gets the value of the grandTotal property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getGrandTotal() {
            if (grandTotal == null) {
            	grandTotal = getTotal();
            	grandTotal = grandTotal.add(getTax());
            	grandTotal = grandTotal.add(getTip());
            }
            
            return grandTotal.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the grandTotal property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setGrandTotal(BigDecimal value) {
            this.grandTotal = value;
        }
        public void setGrandTotal(double value) {
        	setGrandTotal(Util.double2decimal(value));
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
        	if (status == null) {
        		double amountPaid = getAmountPaid().doubleValue();
        		double totalDue = getGrandTotal().doubleValue() - getTip().doubleValue();
        		
        		if (amountPaid >= totalDue ) {
        			status = Transaction.Status.PAID;
        		}
        		else if (amountPaid > 0) {
        			status = Transaction.Status.PARTIALLY_PAID;
        		}
        		else if (totalDue == 0) {
        			status = Transaction.Status.COMP;
        		}
        		else {
        			status = Transaction.Status.NOT_PAID;
        		}
           	}
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the amountPaid property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmountPaid() {
            return amountPaid.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
        }

        /**
         * Sets the value of the amountPaid property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmountPaid(BigDecimal value) {
            this.amountPaid = value;
        }
        public void setAmountPaid(double value) {
        	setAmountPaid(Util.double2decimal(value));
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}time"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "date",
            "time"
        })
        protected static class DateAndTime {

            @XmlElement(required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar date;
            @XmlElement(required = true)
            @XmlSchemaType(name = "time")
            protected XMLGregorianCalendar time;
        	
        	public DateAndTime() {}
        	public DateAndTime(Date date) {
        		setDateAndTime(date);
        	}
        	
        	public DateAndTime(Calendar calendar) {
        		Date date = new Date(calendar.getTimeInMillis());
        		setDateAndTime(date);
        	}
        	
        	public void setDateAndTime(Date date) {

        		XMLGregorianCalendar cal = null;
        		
        		try {
        			cal = getCalendar(date);}
        		catch (DatatypeConfigurationException e) {
	        		e.printStackTrace();
	        	}
        		
        		setDate(cal);
        		setTime(cal);
        	}
        	
        	public XMLGregorianCalendar getCalendar(Date date) throws DatatypeConfigurationException {
        		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        		cal.setTime(date);
        		XMLGregorianCalendar xcal = null;
        		xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        		
        		return xcal;
        	}
        	

            /**
             * Gets the value of the date property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDate() {
                return date;
            }

            /**
             * Sets the value of the date property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDate(XMLGregorianCalendar value) {
                this.date = value;
            }

            /**
             * Gets the value of the time property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getTime() {
                return time;
            }

            /**
             * Sets the value of the time property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setTime(XMLGregorianCalendar value) {
                this.time = value;
            }
        }

        public static class Closed extends DateAndTime{

        	// constructors
        	public Closed() {}
			public Closed(Date date) {
				super(date);
			}
        }
        

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="rewards" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="coupons">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="coupon" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rewards",
            "coupons",
            "quantity",
            "value"
        })
        public static class Discounts {

            @XmlElement(required = true)
            protected String rewards;
            @XmlElement(required = true)
            protected Receipt.Transaction.Discounts.Coupons coupons;
            @XmlSchemaType(name = "unsignedByte")
            protected short quantity;
            @XmlElement(required = true)
            protected BigDecimal value;

            /**
             * Gets the value of the rewards property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public String getRewards() {
                return rewards;
            }

            /**
             * Sets the value of the rewards property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setRewards(String value) {
                this.rewards = value;
            }

            /**
             * Gets the value of the coupons property.
             * 
             * @return
             *     possible object is
             *     {@link Receipt.Transaction.Discounts.Coupons }
             *     
             */
            public Receipt.Transaction.Discounts.Coupons getCoupons() {
            	if (coupons == null) {
            		this.coupons = new Coupons();
            	}
                return coupons;
            }

            /**
             * Sets the value of the coupons property.
             * 
             * @param value
             *     allowed object is
             *     {@link Receipt.Transaction.Discounts.Coupons }
             *     
             */
            public void setCoupons(Receipt.Transaction.Discounts.Coupons value) {
                this.coupons = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             */
            public short getQuantity() {
            	return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             */
            public void setQuantity(short value) {
                this.quantity = value;
            }
            public void setQuantity(int value) {
            	setQuantity(Util.int2ushort(value));
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }
            public void setValue(double value) {
                setValue(Util.double2decimal(value));
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="coupon" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
             *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "coupon"
            })
            public static class Coupons {

                @XmlElement(required = true)
                protected List<Receipt.Transaction.Discounts.Coupons.Coupon> coupon;

                /**
                 * Gets the value of the coupon property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the coupon property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCoupon().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Receipt.Transaction.Discounts.Coupons.Coupon }
                 * 
                 * 
                 */
                public List<Receipt.Transaction.Discounts.Coupons.Coupon> getCoupon() {
                    if (coupon == null) {
                        coupon = new ArrayList<Receipt.Transaction.Discounts.Coupons.Coupon>();
                    }
                    return this.coupon;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
                 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
                 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "id",
                    "name",
                    "value",
                    "quantity"
                })
                public static class Coupon {

                    @XmlSchemaType(name = "unsignedInt")
                    protected long id;
                    @XmlElement(required = true)
                    protected String name;
                    @XmlElement(required = true)
                    protected BigDecimal value;
                    @XmlSchemaType(name = "unsignedByte")
                    protected short quantity;

                    //constructors
                    public Coupon() {}
                    public Coupon(long id) { setId(id); }
                    public Coupon(String id) { setId(id); }
                    public Coupon(int id, String name, double value) { 
                    	setId(id);
                    	setName(name);
                    	setValue(value);
                    	setQuantity(1);
                    }
                    public Coupon(int id, String name, double value, int qty) { 
                    	setId(id);
                    	setName(name);
                    	setValue(value);
                    	setQuantity(1);
                    }
                    public Coupon(String id, String name, double value, int qty) {
                    	setId(id);
                    	setName(name);
                    	setValue(value);
                    	setQuantity(1);
					}
                    
					/**
                     * Gets the value of the id property.
                     * 
                     */
                    public long getId() {
                        return id;
                    }

                    /**
                     * Sets the value of the id property.
                     * 
                     */
                    public void setId(long value) {
                        this.id = value;
                    }

					public void setId(String value) {
						try {
							setId(Long.valueOf(value));
						} catch (NumberFormatException e) { 
							logger.warn(("invalid coupon id: " + value));
						}
					}

                    /**
                     * Gets the value of the name property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public BigDecimal getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    public void setValue(BigDecimal value) {
                        this.value = value;
                    }
                    public void setValue(double value) {
                        setValue(Util.double2decimal(value));
                    }

                    /**
                     * Gets the value of the quantity property.
                     * 
                     */
                    public short getQuantity() {
                        return quantity;
                    }

                    /**
                     * Sets the value of the quantity property.
                     * 
                     */
                    public void setQuantity(short value) {
                        this.quantity = value;
                    }
                    public void setQuantity(int value) {
                        setQuantity(Util.int2ushort(value));
                    }

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="item" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *                   &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *                   &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                   &lt;element name="coupon">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="subtotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item",
            "quantity",
            "subtotal"
        })
        public static class Items {

            @XmlElement(required = true)
            protected List<Receipt.Transaction.Items.Item> item;
            @XmlSchemaType(name = "unsignedByte")
            protected short quantity;
            @XmlElement(required = true)
            protected BigDecimal subtotal;

            /**
             * Gets the value of the item property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the item property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Receipt.Transaction.Items.Item }
             * 
             * 
             */
            public List<Receipt.Transaction.Items.Item> getItem() {
                if (item == null) {
                    item = new ArrayList<Receipt.Transaction.Items.Item>();
                }
                return this.item;
            }

            /**
             * Gets the value of the quantity property.
             * 
             */
            public short getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             */
            public void setQuantity(short value) {
                this.quantity = value;
            }
            public void setQuantity(int value) {
                setQuantity(Util.int2ushort(value));
            }

            /**
             * Gets the value of the subtotal property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getSubtotal() {
            	if (subtotal == null) {
            		subtotal = new BigDecimal(0.00);
	            	
	            	for (Item item : getItem()) {
	        			subtotal = Util.add(subtotal, item.getTotal());
	        		}
            	}
            	
            	return subtotal;
            }

            /**
             * Sets the value of the subtotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setSubtotal(BigDecimal value) {
                this.subtotal = value;
            }
            public void setSubtotal(double value) {
                setSubtotal(Util.double2decimal(value));
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
             *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
             *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *         &lt;element name="coupon">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "description",
                "itemId",
                "qty",
                "unitPrice",
                "coupon",
                "total"
            })
            public static class Item {

                @XmlElement(required = true)
                protected String description;
                @XmlSchemaType(name = "unsignedInt")
                protected long itemId;
                @XmlSchemaType(name = "unsignedByte")
                protected short qty;
                @XmlElement(required = true)
                protected BigDecimal unitPrice;
                @XmlElement(required = true)
                protected Receipt.Transaction.Items.Item.Coupon coupon;
                @XmlElement(required = true)
                protected BigDecimal total;

                // Constructors
                public Item() {}
                public Item(long itemId, String description, double price, int quantity) {
					setItemId(itemId);
					setDescription(description);
					setUnitPrice(price);
					setQty(qty);
				}
                public Item(String itemId, String description, double price, int quantity) {
					setItemId(itemId);
					setDescription(description);
					setUnitPrice(price);
					setQty(qty);
				}
                public Item(long itemId, String description, BigDecimal price, int quantity) {
					setItemId(itemId);
					setDescription(description);
					setUnitPrice(price);
					setQty(qty);
				}
                public Item(String itemId, String description, BigDecimal price, int quantity) {
					this.itemId = Long.valueOf(itemId);
					this.description = description;
					setUnitPrice(price);
					setQty(qty);
				}

				/**
                 * Gets the value of the description property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 * Sets the value of the description property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescription(String value) {
                    this.description = value;
                }

                /**
                 * Gets the value of the itemId property.
                 * 
                 */
                public long getItemId() {
                    return itemId;
                }

                /**
                 * Sets the value of the itemId property.
                 * 
                 */
                public void setItemId(long value) {
                    this.itemId = value;
                }
                public void setItemId(String value) {
                	try {
						this.itemId = Long.valueOf(value);
					} catch (NumberFormatException ex) {
						logger.warn(("invalid item id: " + itemId));
					}
                }

                /**
                 * Gets the value of the qty property.
                 * 
                 */
                public short getQty() {
                    return qty;
                }

                /**
                 * Sets the value of the qty property.
                 * 
                 */
                public void setQty(short value) {
                    this.qty = value;
                }
                public void setQty(int value) {
                    setQty(Util.int2ushort(value));
                }

                /**
                 * Gets the value of the unitPrice property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getUnitPrice() {
                    return unitPrice;
                }

                /**
                 * Sets the value of the unitPrice property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setUnitPrice(BigDecimal value) {
                    this.unitPrice = value;
                }
                public void setUnitPrice(double value) {
                    setUnitPrice(Util.double2decimal(value));
                }
                

                /**
                 * Gets the value of the coupon property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Receipt.Transaction.Items.Item.Coupon }
                 *     
                 */
                public Receipt.Transaction.Items.Item.Coupon getCoupon() {
                    return coupon;
                }

                /**
                 * Sets the value of the coupon property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Receipt.Transaction.Items.Item.Coupon }
                 *     
                 */
                public void setCoupon(Receipt.Transaction.Items.Item.Coupon value) {
                    this.coupon = value;
                }

                /**
                 * Gets the value of the total property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTotal() {
                	if (total == null) {
                		total = Util.multiply(getUnitPrice(), getQty());
                	}
                	
                    return total;
                }

                /**
                 * Sets the value of the total property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTotal(BigDecimal value) {
                    this.total = value;
                }
                public void setTotal(double value) {
                    setTotal(Util.double2decimal(value));
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "id"
                })
                public static class Coupon {

                
                    @XmlSchemaType(name = "unsignedInt")
                    protected long id;
                    
                    // constructors
                	public Coupon() {}
                	public Coupon(long id) { setId(id); }
                	public Coupon(String id) { setId(id); }
                    
                	
                    /**
                     * Gets the value of the id property.
                     * 
                     */
                    public long getId() {
                        return id;
                    }

                    /**
                     * Sets the value of the id property.
                     * 
                     */
                    public void setId(long value) {
                        this.id = value;
                    }
					public void setId(String value) {
						try {
							this.id = Long.valueOf(value);
						} catch (NumberFormatException ex) {
							logger.warn(("invalid coupon id: " + value));
						}
					}

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="taxableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rate",
            "taxableAmount",
            "total"
        })
        public static class Salestax {

            @XmlElement(required = true)
            protected BigDecimal rate;
            @XmlElement(required = true)
            protected BigDecimal taxableAmount;
            @XmlElement(required = true)
            protected BigDecimal total;

            // constructors
            public Salestax() {}
           public Salestax(double rate) { this.rate = Util.double2decimal(rate); }
            public Salestax(BigDecimal rate, BigDecimal taxableAmount) { 
            	setRate(rate); 
            	setTaxableAmount(taxableAmount);
            }
            public Salestax(double rate, double taxableAmount) { 
            	setRate(rate); 
            	setTaxableAmount(taxableAmount);
            }
            
            /**
             * Gets the value of the rate property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getRate() {
                return rate.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
            }

            /**
             * Sets the value of the rate property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setRate(BigDecimal value) {
                this.rate = value;
            }
			public void setRate(double rate) {
				this.rate = Util.double2decimal(rate);
			}

            /**
             * Gets the value of the taxableAmount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTaxableAmount() {
                return taxableAmount.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
            }

            /**
             * Sets the value of the taxableAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTaxableAmount(BigDecimal value) {
                this.taxableAmount = value;
            }
            public void setTaxableAmount(double value) {
                setTaxableAmount(Util.double2decimal(value));
            }

            /**
             * Gets the value of the total property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getTotal() {
            	if (total == null) {
					BigDecimal taxRate = Util.divide(getRate(), 100);
            		total = getTaxableAmount().multiply(taxRate).setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
            	}
            	
                return total.setScale(Receipt.DECIMAL_PLACES, BigDecimal.ROUND_HALF_UP);
            }

            /**
             * Sets the value of the total property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setTotal(BigDecimal value) {
                this.total = value;
            }
            public void setTotal(double value) {
                setTotal(Util.double2decimal(value));
            }
        }
    }
}
