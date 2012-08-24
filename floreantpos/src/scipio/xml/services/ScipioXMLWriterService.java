//-AE-
package scipio.xml.services;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.floreantpos.model.Ticket;
import java.io.*;
import java.net.URISyntaxException;

import scipio.xml.model.Receipt;

public class ScipioXMLWriterService {
	public String ReceiptOutputDir = "xml_receipts";
	public static final String UTF_8 = "UTF-8";

	private static final Logger logger = Logger.getLogger(ScipioXMLWriterService.class.getName());
	
	public void writeReceipt(Ticket ticket) throws ScipioException {
		ReceiptBuilder builder = new ReceiptBuilder();
		try {
			Receipt receipt = builder.createReceipt(ticket);
			if (receipt == null) { 
				throw new ScipioException("receipt is null"); 
			}
			FileOutputStream out = getReceiptOutputStream(ticket);
			writeXmlReceipt(receipt, out);
			//writeXmlReceipt(receipt, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String writeReceiptXMLString(Receipt receipt) throws JAXBException, UnsupportedEncodingException {	
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		writeXmlReceipt(receipt, stream);
		
		String xmlString = null;
		
		try {
			xmlString = stream.toString(UTF_8);
		} catch (UnsupportedEncodingException ex) {
			logger.log(Level.SEVERE, null, ex);
			xmlString = stream.toString();
		}
		
		return xmlString;
	}
	
	public void writeXmlReceipt(Receipt receipt, OutputStream out) {
		JAXBContext context;
		
		try {
			context = JAXBContext.newInstance(Receipt.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(receipt, out);
		} catch (JAXBException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
	}
	
	
//	public File getApplicationDir() {
//		URL url = this.getClass().getResource("/");
//		return new File(url.getPath()).getParentFile();
//	}
	
	public File getApplicationDir() {
		File applicationDir = null;
				
		try {
			applicationDir = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
		} catch (URISyntaxException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
		
		return applicationDir;
	}
	
	public File getXmlReceiptsDir() throws IOException {
		File xmlReceiptsDir = new File(getApplicationDir().getCanonicalPath() + "/" + ReceiptOutputDir);
		
		if (! xmlReceiptsDir.exists()) {
			xmlReceiptsDir.mkdir();
		}
		if (! xmlReceiptsDir.isDirectory()) {
			throw new IOException("File exists where directory is expected: " + xmlReceiptsDir.getCanonicalPath());
		} 

		return xmlReceiptsDir;
	}
	
	public String getReceiptFileName(Ticket ticket) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		String closeDate = dateFormat.format(ticket.getClosingDate());
		String receiptFileName = "receipt_" + closeDate + "_" + ticket.getId() + ".xml";
		
		return receiptFileName;
	}
	
	public FileOutputStream getReceiptOutputStream(Ticket ticket) {
		FileOutputStream out = null;
		
		try {
			File file = new File(getXmlReceiptsDir().getCanonicalPath() + "/" + getReceiptFileName(ticket));
			logger.info("xml receipt: " + file.getAbsoluteFile());
			//file.createNewFile();
			out = new FileOutputStream(file);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
		
		return out;
	}
}
