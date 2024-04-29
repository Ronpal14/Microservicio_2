package com.pragma.powerup;

import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.domain.usecase.RestaurantUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantTest {

    @InjectMocks
    private RestaurantUseCase restaurantUseCase;

    @Mock
    private IRestaurantPersistencePort restaurantPersistencePort;

    @Test
    void createRestaurant(){

        RestaurantModel expectedRestaurant = new RestaurantModel(1L, "HamburguesasFood",12345,"VenturaPlaza",
                "32234543","imagen.com",1L);

        RestaurantModel testRestaurant = new RestaurantModel();
        testRestaurant.setId(1L);
        testRestaurant.setName("HamburguesasFood");
        testRestaurant.setNit(12345);
        testRestaurant.setAddress("VenturaPlaza");
        testRestaurant.setPhone("32234543");
        testRestaurant.setUrlLogo("imagen.com");
        testRestaurant.setIdOwner(1L);
        when(restaurantPersistencePort.createRestaurant(testRestaurant)).thenReturn(expectedRestaurant);

        RestaurantModel resultWhenCreatingRestaurant = restaurantUseCase.createRestaurant(testRestaurant);

        verify(restaurantPersistencePort).createRestaurant(testRestaurant);
        assertThat(testRestaurant, samePropertyValuesAs(expectedRestaurant));

    }
}