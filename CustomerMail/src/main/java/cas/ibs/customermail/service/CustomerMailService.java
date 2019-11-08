package cas.ibs.customermail.service;

public class CustomerMailService {

	
	public void sendEmailToCustomer() {
		String pnrLoc="";
		String name="";
		
		SendEmailTLS.sendEmail(pnrLoc,name);
	}
}
