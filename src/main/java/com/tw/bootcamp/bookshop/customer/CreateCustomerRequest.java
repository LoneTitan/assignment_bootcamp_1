package com.tw.bootcamp.bookshop.customer;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode

public class CreateCustomerRequest {
    private String name;
}
