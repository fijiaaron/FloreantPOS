package com.floreantpos.config.ui;

import com.floreantpos.config.ApplicationConfig;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import net.miginfocom.swing.MigLayout;

import com.floreantpos.main.Application;
import com.floreantpos.model.Restaurant;
import com.floreantpos.model.Terminal;
import com.floreantpos.model.dao.RestaurantDAO;
import com.floreantpos.model.dao.TerminalDAO;
import com.floreantpos.swing.FixedLengthTextField;
import com.floreantpos.ui.dialog.POSMessageDialog;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class RestaurantConfigurationView extends ConfigurationView {
	private RestaurantDAO dao;
	private Restaurant restaurant;
	
	//-AE-
	private TerminalDAO terminalDAO;
	private Terminal terminal;
	
	private JTextField tfRestaurantName = new FixedLengthTextField(40);
	private JTextField tfAddressLine1 = new FixedLengthTextField(20);
	private JTextField tfAddressLine2 = new FixedLengthTextField(20);
	private JTextField tfAddressLine3 = new FixedLengthTextField(20);
	private JTextField tfTelephone = new FixedLengthTextField(16);
	private JTextField tfCurrencyName = new FixedLengthTextField(20);
	private JTextField tfCurrencySymbol = new FixedLengthTextField(10);
	private JTextField tfCapacity = new JTextField();
	private JTextField tfTable = new JTextField();
	
	//-AE-
	private static int SMI_LENGTH = 6;
	//private JFormattedTextField tfSMI = new JFormattedTextField(createFormatter(SMI_LENGTH)); // inhibits touchpad
	private JFormattedTextField tfSMI = new JFormattedTextField();
	private JFormattedTextField tfTerminal = new JFormattedTextField();
	
	public RestaurantConfigurationView() {
		setLayout(new MigLayout("align 50% 50%"));
		
		addRow(com.floreantpos.POSConstants.RESTAURANT_NAME_, tfRestaurantName, "w 300");
		addRow(com.floreantpos.POSConstants.ADDRESS_LINE1, tfAddressLine1, "w 300");
		addRow(com.floreantpos.POSConstants.ADDRESS_LINE2, tfAddressLine2, "w 300");
		addRow(com.floreantpos.POSConstants.ADDRESS_LINE3, tfAddressLine3, "w 300");
		addRow(com.floreantpos.POSConstants.TELEPHONE + ":", tfTelephone, "w 150");
		addRow(com.floreantpos.POSConstants.CAPACITY_, tfCapacity, "w 150");
		addRow(com.floreantpos.POSConstants.TABLES + ":", tfTable, "w 150");
		addRow(com.floreantpos.POSConstants.CURRENCY_NAME_, tfCurrencyName, "w 50");
		addRow(com.floreantpos.POSConstants.CURRENCY_SYMBOL_, tfCurrencySymbol, "w 50");
		
		//-AE-
		addRow(com.floreantpos.POSConstants.SMI, tfSMI, "w 50");
		addRow(com.floreantpos.POSConstants.TERMINAL, tfTerminal, "w 50");
	}

	//-AE-
	private MaskFormatter createFormatter(int length) {
		String mask = StringUtils.repeat("#", length);
		MaskFormatter formatter = null;
		
		try {
			formatter = new MaskFormatter(mask);
		} catch (ParseException e) {
			e.printStackTrace();
			formatter = new MaskFormatter();
		}
		
		return formatter;
	}
		
	@Override
	public boolean save() throws Exception {
		if(!isInitialized()) {
			return true;
		}
		
		String name = null;
		String addr1 = null;
		String addr2 = null;
		String addr3 = null;
		String telephone = null;
		String currencyName = null;
		String currencySymbol = null;
		
		//-AE-
		Integer smi = null;
		String terminalName = null;
		
		int capacity = 299;
		int tables = 74;

		name = tfRestaurantName.getText();
		addr1 = tfAddressLine1.getText();
		addr2 = tfAddressLine2.getText();
		addr3 = tfAddressLine3.getText();
		telephone = tfTelephone.getText();
		currencyName = tfCurrencyName.getText();
		currencySymbol = tfCurrencySymbol.getText();
		
		if(StringUtils.isEmpty(currencyName)) {
			currencyName = com.floreantpos.POSConstants.DOLLAR;
		}
		if(StringUtils.isEmpty(currencySymbol)) {
			currencySymbol = "$";
		}
		
		try {
			capacity = Integer.parseInt(tfCapacity.getText());
		} catch (Exception e) {
			POSMessageDialog.showError(this, com.floreantpos.POSConstants.CAPACITY_IS_NOT_VALID_);
			return false;
		}

		try {
			tables = Integer.parseInt(tfTable.getText());
		} catch (Exception e) {
			POSMessageDialog.showError(this, com.floreantpos.POSConstants.NUMBER_OF_TABLES_IS_NOT_VALID);
			return false;
		}

		//-AE-
		try {
			smi = Integer.parseInt(tfSMI.getText());
		} catch (Exception e) {
			POSMessageDialog.showError(this, com.floreantpos.POSConstants.SMI_IS_NOT_VALID);
			return false;
		}
		try {
			if (tfSMI.getText().length() != SMI_LENGTH) { 
				throw new Exception("SMI must be " + SMI_LENGTH + " digits");
			}
		} catch (Exception e) {
			POSMessageDialog.showError(this, e.getMessage());
			return false;
		}
		
		terminalName = tfTerminal.getText();
		
		restaurant.setName(name);
		restaurant.setAddressLine1(addr1);
		restaurant.setAddressLine2(addr2);
		restaurant.setAddressLine3(addr3);
		restaurant.setTelephone(telephone);
		restaurant.setCapacity(capacity);
		restaurant.setTables(tables);
		restaurant.setCurrencyName(currencyName);
		restaurant.setCurrencySymbol(currencySymbol);
		
		//-AE-
		restaurant.setSmi(smi);
	
		dao.saveOrUpdate(restaurant);

		//-AE-
		terminal.setName(terminalName);
		terminalDAO.saveOrUpdate(terminal);
		
		Application.getInstance().refreshRestaurant();
		
		return true;
	}
	
	@Override
	public void initialize() throws Exception {
		dao = new RestaurantDAO();
		restaurant = dao.get(Integer.valueOf(1));

		//-AE-
		terminalDAO = new TerminalDAO();
		terminal = terminalDAO.get(ApplicationConfig.getTerminalId());
		
		tfRestaurantName.setText(restaurant.getName());
		tfAddressLine1.setText(restaurant.getAddressLine1());
		tfAddressLine2.setText(restaurant.getAddressLine2());
		tfAddressLine3.setText(restaurant.getAddressLine3());
		tfTelephone.setText(restaurant.getTelephone());
		tfCapacity.setText(String.valueOf(restaurant.getCapacity()));
		tfTable.setText(String.valueOf(restaurant.getTables()));
		tfCurrencyName.setText(restaurant.getCurrencyName());
		tfCurrencySymbol.setText(restaurant.getCurrencySymbol());
		
		//-AE-
		if (restaurant.getSmi() != null) {
			tfSMI.setText(String.valueOf(restaurant.getSmi()));
		} else {
			tfSMI.setText("");
		}
		
		if (terminal.getName() != null) {
			tfTerminal.setText(String.valueOf(terminal.getName()));
		} else {
			tfTerminal.setText("");
		}
		
		setInitialized(true);
	}
	
	@Override
	public String getName() {
		return com.floreantpos.POSConstants.RESTAURANT_CONFIGURATION;
	}
}
