package edu.mrUni.crm.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id",length =5)
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_first_name",length =25,nullable = false)
    private String customerFirstName;

    @Column(name = "customer_last_name",length =25)
    private String customerLastName;

    @Column(name = "customer_email",length =30)
    private String customerEmail;

    @Column(name = "customer_phone_number",length =10,nullable = false)
    private String customerPhoneNumber;

    @Column(name = "customer_password",length =12,nullable = false)
    private String password;

    @Column(name="customer_active_status",length =1,nullable = false)
    private boolean activeStatus;

}
