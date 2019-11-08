package cas.ibs.ediconv.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cas.ibs.ediconv.dto.PNRDto;

public class XmlToDtoConverter {

	public static PNRDto getObjectFromXml(String msg) throws IOException {

		/*
		 * byte[] content = Files.readAllBytes(Paths.get("inputmessage.edi")); String
		 * sts = new String(content);
		 */
		JAXBContext jaxbContext;
		PNRDto pnr = null;
		try {
			jaxbContext = JAXBContext.newInstance(PNRDto.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			pnr = (PNRDto) jaxbUnmarshaller.unmarshal(new StringReader(msg));
			return pnr;
		} catch (JAXBException e) {
			e.printStackTrace();
			return pnr;
		}

	}

}
