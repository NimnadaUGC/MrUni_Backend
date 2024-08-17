package edu.mrUni.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mrUni.crm.dto.CustomerDTO;
import edu.mrUni.crm.dto.request.CustomerUpdateDTO;
import edu.mrUni.crm.entity.Customer;
import edu.mrUni.crm.repository.CustomerRepository;
import edu.mrUni.crm.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        //convert customerDTO to customer
        Customer customer = mapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
        return "Saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        //check if customer exist
        if (customerRepository.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepository.getReferenceById(customerUpdateDTO.getCustomerId());
            customer = mapper.map(customerUpdateDTO, Customer.class);
            customerRepository.save(customer);
        } else {
            System.out.println("hey");
            ;
        }
        return "Updated";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        //check if customer exist
        if (customerRepository.existsById(customerId)) {
            Customer customer = customerRepository.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerFirstName(customer.getCustomerFirstName());
            customerDTO.setCustomerLastName(customer.getCustomerLastName());
            customerDTO.setCustomerEmail(customer.getCustomerEmail());
            customerDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());
            customerDTO.setCustomerFirstName(customer.getCustomerFirstName());

            return customerDTO;
        } else {
            throw new RuntimeException("No Customer");
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setCustomerEmail(customer.getCustomerEmail());
            customerDTO.setCustomerFirstName(customer.getCustomerFirstName());
            customerDTO.setCustomerLastName(customer.getCustomerLastName());
            customerDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return "Deleted";
        } else {
            throw new RuntimeException("No Customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean status) {
        List<Customer> customers = customerRepository.findAllByActiveStatus(status);
        List<CustomerDTO> customerDTOList = new ArrayList<CustomerDTO>();
        for (Customer customer : customers) {
            if (customer.isActiveStatus() == status) {
                CustomerDTO customerDTO = new CustomerDTO();

                customerDTO.setCustomerId(customer.getCustomerId());
                customerDTO.setCustomerEmail(customer.getCustomerEmail());
                customerDTO.setCustomerFirstName(customer.getCustomerFirstName());
                customerDTO.setCustomerLastName(customer.getCustomerLastName());
                customerDTO.setCustomerPhoneNumber(customer.getCustomerPhoneNumber());

                customerDTOList.add(customerDTO);
            }
        }
        return customerDTOList;
    }
}
