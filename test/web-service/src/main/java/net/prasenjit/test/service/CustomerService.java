package net.prasenjit.test.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Component;

import net.prasenjit.test.contact.Customer;
import net.prasenjit.test.contact.NoSuchCustomerException;

@Component
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CustomerService {
	@WebResult(name="customer")
	public Customer getCustomersByName(@WebParam(name = "name") String name) throws NoSuchCustomerException;
}
