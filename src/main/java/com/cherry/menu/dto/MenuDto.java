package com.cherry.menu.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private  int id;

    private String itemName;

    private  String itemDescription;
    private String isVeg;

    private  Long price;
    private Integer restaurantId;

    private  Integer quantity;


}
