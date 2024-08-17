package edu.mrUni.crm.dto;

import lombok.Data;


@Data //setter,getter,toString,equals,hashcode
public class CustomerDTO {

    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String password;
    private boolean activeStatus;
}
