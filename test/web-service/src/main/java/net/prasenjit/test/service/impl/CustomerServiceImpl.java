package net.prasenjit.test.service.impl;

import net.prasenjit.test.contact.Customer;
import net.prasenjit.test.contact.NoSuchCustomerException;
import net.prasenjit.test.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer getCustomersByName(String name) throws NoSuchCustomerException {
		if ("nn".equals(name)) {
			throw new NoSuchCustomerException(name);
		}
		Customer customer = new Customer();
		customer.setName(name);
		return customer;
	}

}
