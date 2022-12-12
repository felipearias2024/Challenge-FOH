package com.foh.ChallengeFoh.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "full_name", length = 100)
    private String name;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email_address")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
