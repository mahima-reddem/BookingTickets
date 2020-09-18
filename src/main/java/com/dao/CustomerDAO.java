package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Customer;

public class CustomerDAO {
	
private SessionFactory factory = null;
	
	public Customer getCustomerByName(String custName, String custPassword){
		return (Customer)HibernateTemplate.getObjectByName(custName, custPassword);
	}
	
	public int register(Customer customer) {		
		return HibernateTemplate.addObject(customer);
	}
	
	public List<Customer> getAllCustomers(){
		System.out.println("In getallcust in cust dao");
		List<Customer> customers = (List)HibernateTemplate.getObjectListByQuery("from Customer");
		System.out.println("Inside All Customers ..."+customers);
		return customers;
	}
	
	
	public Customer getCustomer(int id){
		return (Customer)HibernateTemplate.getObject(Customer.class,id);
	}
	
	public int editCustomer(Customer customer){
		return HibernateTemplate.updateObject(customer);
	}
	
	public int deleteCustomer(int id){
		return HibernateTemplate.deleteObject(Customer.class, id);
	}
	

}
