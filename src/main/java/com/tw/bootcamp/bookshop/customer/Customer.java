package com.tw.bootcamp.bookshop.customer;

import com.tw.bootcamp.bookshop.money.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Customer(String name) {
        this.name = name;
    }

    public CustomerResponse toResponse() {
        return CustomerResponse.builder()
                .id(id)
                .name(name)
                .build();
    }
}
