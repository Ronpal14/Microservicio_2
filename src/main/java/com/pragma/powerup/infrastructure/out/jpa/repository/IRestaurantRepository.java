package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRestaurantRepository extends JpaRepository<RestaurantEntity,Long> {

    Optional<RestaurantEntity> findRestaurantByName(String restaurantName);
    Optional<RestaurantEntity> findOwnerById(Long ownerId);
}