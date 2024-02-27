package com.cherry.menu.service;


import com.cherry.menu.dto.MenuDto;
import com.cherry.menu.dto.MenuPage;
import com.cherry.menu.dto.Restaurant;
import com.cherry.menu.entity.Menu;
import com.cherry.menu.mapper.MenuMapper;
import com.cherry.menu.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuRepo menuRepo;

    @Autowired
    RestTemplate restTemplate;

    public MenuDto saveItemToMenu(MenuDto menuDto) {
        Menu saveditem = menuRepo.save(MenuMapper.INSTANCE.mapMenuDtoToMenu(menuDto));
        return  MenuMapper.INSTANCE.mapMenuToMenuDto(saveditem);


    }

    public MenuPage getMenuDetailsById(Integer restaurantid) {
      List<Menu> menuList=  getMenuByID(restaurantid);
      Restaurant restaurant=  getRestaurantDetailsByID(restaurantid);
      return createMenuPage(menuList, restaurant);
    }

     private List<Menu> getMenuByID(Integer restaurantid){
      return  menuRepo.findByRestaurantId(restaurantid);
     }


    private Restaurant getRestaurantDetailsByID(Integer restaurantid){
        return restTemplate.getForObject("http://RESTATURANT-SERVICE/restaurant/getRestaurantById/" + restaurantid, Restaurant.class);
    }

    private MenuPage createMenuPage(List<Menu> menuList, Restaurant restaurant){

        MenuPage menuPage= new MenuPage();
        menuPage.setMenus(menuList);
        menuPage.setRestaurant(restaurant);
        return  menuPage;


    }
}
