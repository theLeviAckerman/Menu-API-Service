package com.cherry.menu.repo;

import com.cherry.menu.entity.Menu;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Integer> {
    List<Menu> findByRestaurantId(Integer restaurantId);

}
