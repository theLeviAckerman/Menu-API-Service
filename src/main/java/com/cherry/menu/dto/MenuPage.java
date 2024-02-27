package com.cherry.menu.dto;


import com.cherry.menu.entity.Menu;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPage {

    private List<Menu> menus;

    private Restaurant restaurant;
}
