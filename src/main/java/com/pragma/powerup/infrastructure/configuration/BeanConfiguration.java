package com.pragma.powerup.infrastructure.configuration;


import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.usecase.RestaurantUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;

import com.pragma.powerup.infrastructure.out.jpa.repository.IRestaurantRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(IRestaurantRepository restaurantRepository, IRestaurantEntityMapper restaurantEntityMapper){
        return new RestaurantJpaAdapter(restaurantRepository,restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort(IRestaurantPersistencePort restaurantPersistencePort){
        return new RestaurantUseCase(restaurantPersistencePort);
    }

}