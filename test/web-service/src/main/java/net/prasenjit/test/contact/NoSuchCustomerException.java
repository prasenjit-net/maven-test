package net.prasenjit.test.contact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@WebFault(name = "NoSuchCustomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class NoSuchCustomerException extends RuntimeException {
	private static final long serialVersionUID = 4690213846744784430L;

	String customerName;

	public NoSuchCustomerException(String name) {
		customerName = name;
	}

	public String getCustomerName() {
		return customerName;
	}
}