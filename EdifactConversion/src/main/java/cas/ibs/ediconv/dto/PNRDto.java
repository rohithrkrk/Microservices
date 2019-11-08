package cas.ibs.ediconv.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PNR")
public class PNRDto {
	private Header header;
	public Header getHeader() {
		return header;
	}
	@XmlElement(name = "header")
	public void setHeader(Header header) {
		this.header = header;
	}
}

class Header{
	private String name;
	private String rloc;
	
	public String getName() {
		return name;
	}
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	public String getRloc() {
		return rloc;
	}
	@XmlElement(name = "locator")
	public void setRloc(String rloc) {
		this.rloc = rloc;
	}
}
