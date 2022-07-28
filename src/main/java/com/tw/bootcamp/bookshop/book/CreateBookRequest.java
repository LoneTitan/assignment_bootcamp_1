package com.tw.bootcamp.bookshop.book;

import com.tw.bootcamp.bookshop.money.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embedded;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class CreateBookRequest {
    private final String name;
    private String authorName;
    private Money price;
    private String imageUrl;

}