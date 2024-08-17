package edu.mrUni.crm.controller;

import edu.mrUni.crm.dto.CustomerDTO;
import edu.mrUni.crm.dto.request.CustomerUpdateDTO;
import edu.mrUni.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //define as a controller, @Controller + @ResponseBody,get req and give res,@ResponseBody -> give response to frontend
@RequestMapping("api/v1/customer")
@CrossOrigin //use spring security to req only accept from define frontend url
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){//map json object to java object
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){//map json object to java object
        return customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id" //view as  frontEnd /get-by-id?id=10
    )
    public CustomerDTO  getCustomerById(@RequestParam(value = "id")int customerId){//map json object to java object
        CustomerDTO customerDTO=customerService.getCustomerById(customerId);
        return customerDTO;
    }

   @GetMapping("get-all-customers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int customerId ){
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping(path = "get-all-customers-by-active-status")
    public List<CustomerDTO> getAllCustomersByActiveStatus(@Param("status") boolean status){
        return customerService.getAllCustomersByActiveStatus(status);
    }




}
