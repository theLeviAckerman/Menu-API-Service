package com.cherry.menu.controller;


import com.cherry.menu.dto.MenuDto;
import com.cherry.menu.dto.MenuPage;
import com.cherry.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/addItemToMenu")
    public ResponseEntity<MenuDto> addItemToMenu(@RequestBody MenuDto menuDto){
        MenuDto savedItem = menuService.saveItemToMenu(menuDto);
        return new ResponseEntity<>(savedItem, HttpStatus.OK);
    }

    @GetMapping("/getMenu/{restaurantId}")
    public ResponseEntity<MenuPage> getTheMenuDetails(@PathVariable Integer restaurantId){

       MenuPage menuPage= menuService.getMenuDetailsById(restaurantId);
       return new ResponseEntity<>(menuPage, HttpStatus.OK);

    }




}
