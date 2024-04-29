package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.RestaurantModel;
import org.springframework.data.domain.Page;

public interface IRestaurantServicePort {

    RestaurantModel createRestaurant(RestaurantModel restaurantModel);
}