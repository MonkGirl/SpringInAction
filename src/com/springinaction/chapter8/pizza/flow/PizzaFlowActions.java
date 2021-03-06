package com.springinaction.chapter8.pizza.flow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springinaction.chapter8.pizza.domain.CashOrCheckPayment;
import com.springinaction.chapter8.pizza.domain.CreditCardPayment;
import com.springinaction.chapter8.pizza.domain.Customer;
import com.springinaction.chapter8.pizza.domain.Order;
import com.springinaction.chapter8.pizza.domain.Payment;
import com.springinaction.chapter8.pizza.domain.PaymentDetails;
import com.springinaction.chapter8.pizza.domain.PaymentType;
import com.springinaction.chapter8.pizza.service.CustomerNotFoundException;
import com.springinaction.chapter8.pizza.service.CustomerService;

@Component
public class PizzaFlowActions {
	private static final Logger LOGGER = LogManager.getLogger(PizzaFlowActions.class);
	
	@Autowired
	private CustomerService customerService;
	
	public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException{
		Customer customer = customerService.lookupCustomer(phoneNumber);
		if(customer!=null) {
			return customer;
		}else {
			throw new CustomerNotFoundException();
		}
	}
	
	public void addCustomer(Customer customer) {
		LOGGER.warn("TODO: Flesh out the addCustomer() method.");
	}
	
	public Payment verifyPayment(PaymentDetails paymentDetails) {
		Payment payment = null;
		if(paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
			payment = new CreditCardPayment();
		}else {
			payment = new CashOrCheckPayment();
		}
		return payment;
	}
	
	public void saveOrder(Order order) {
		LOGGER.warn("TODO: Flesh out the saveOrder() method.");
	}
	
	public boolean checkDeliveryArea(String zipCode) {
		LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
		return "75075".equals(zipCode);
	}
}
