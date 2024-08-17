package edu.mrUni.crm.service;

import edu.mrUni.crm.dto.CustomerDTO;
import edu.mrUni.crm.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerId);

    public  List<CustomerDTO> getAllCustomers();


    public String deleteCustomer(int customerId);

    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean status);
}
