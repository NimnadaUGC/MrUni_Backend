package edu.mrUni.crm.dto.request;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private int customerId;
    private String customerEmail;
    private String customerPhoneNumber;
    private String password;
}
