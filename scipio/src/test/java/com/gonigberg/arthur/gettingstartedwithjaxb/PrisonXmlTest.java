package com.gonigberg.arthur.gettingstartedwithjaxb;
import static org.junit.Assert.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;


public class PrisonXmlTest {

	@Test
	public void testXml() throws JAXBException {
		Prison prison = new Prison();
		
		Guard guard = new Guard();
		guard.setName("Jim");
		guard.setAssignment("Toilet Scrubbing");
		
		Inmate inmate = new Inmate();
		inmate.setName("Billy the Knife");
		
		Cell cell = new Cell();
		cell.setId("C4");
		cell.setInmate(inmate);
		
		prison.setGuard(guard);
		prison.setCell(cell);
		

		JAXBContext context = JAXBContext.newInstance(Prison.class);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(prison, System.out);
		
	}

}
