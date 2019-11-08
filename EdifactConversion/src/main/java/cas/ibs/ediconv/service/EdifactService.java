package cas.ibs.ediconv.service;

import java.io.IOException;

import org.milyn.SmooksException;
import org.xml.sax.SAXException;

import cas.ibs.ediconv.dto.PNRDto;
import cas.ibs.ediconv.util.EdifactConverter;
import cas.ibs.ediconv.util.XmlToDtoConverter;

public class EdifactService {
	
	public PNRDto edifactRecieve() throws SmooksException, IOException, SAXException {
		 String messageOut = EdifactConverter.runSmooksTransform();
	      return XmlToDtoConverter.getObjectFromXml(messageOut);
	}

}
