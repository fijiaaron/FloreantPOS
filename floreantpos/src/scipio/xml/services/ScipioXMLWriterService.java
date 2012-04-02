//-AE-
package scipio.xml.services;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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

	private static final Logger log = Logger.getLogger(ScipioXMLWriterService.class.getName());
	
	public void writeReceipt(Ticket ticket) throws ScipioException {
		ReceiptBuilder builder = new ReceiptBuilder();
		try {
			Receipt receipt = builder.createReceipt(ticket);
			if (receipt == null) { 
				throw new ScipioException("receipt is null"); 
			}
			FileOutputStream out = getReceiptOutputStream(ticket);
			writeXmlReceipt(receipt, out);
			//TODO: remove STDOUT receipt
			writeXmlReceipt(receipt, System.out);
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
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			log.warning(e.getMessage());
			log.info(e.getStackTrace().toString());
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
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			log.severe(e.getErrorCode());
			log.info(e.getStackTrace().toString());
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
			System.out.println(applicationDir.getCanonicalPath());
		} catch (URISyntaxException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return applicationDir;
	}
	
	public File getXmlReceiptsDir() throws IOException {
		File xmlReceiptsDir = new File(getApplicationDir().getCanonicalPath() + "/" + ReceiptOutputDir);
		System.out.println("xml_receiptsDir: " + xmlReceiptsDir.getCanonicalPath());

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
		String receiptFileName = "receipt_" + closeDate + ".xml";
		System.out.println("receiptFileName: " + receiptFileName);
		
		return receiptFileName;
	}
	
	public FileOutputStream getReceiptOutputStream(Ticket ticket) {
		FileOutputStream out = null;
		
		try {
			File file = new File(getXmlReceiptsDir().getCanonicalPath() + "/" + getReceiptFileName(ticket));
			System.out.println(file.getAbsoluteFile());
			//file.createNewFile();
			out = new FileOutputStream(file);
		} catch (IOException ex) {
			Logger.getLogger(ScipioXMLWriterService.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return out;
	}
}
