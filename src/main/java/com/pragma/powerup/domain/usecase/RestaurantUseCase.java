package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.exception.InvalidInputException;
import com.pragma.powerup.domain.model.RestaurantModel;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public RestaurantModel createRestaurant(RestaurantModel restaurantModel) {
        validateName(restaurantModel);
        validateAddress(restaurantModel);
        validateNit(restaurantModel);
        validatePhone(restaurantModel);
        validateUrlLogo(restaurantModel);
        validateIdOwner(restaurantModel);
        return restaurantPersistencePort.createRestaurant(restaurantModel);
    }

    private void validateName(RestaurantModel restaurantModel){
        if (!restaurantModel.isName()){
            throw new InvalidInputException("El nombre del restaurante no puede tener únicamente números.");
        }
        if (restaurantModel.getName() == null || restaurantModel.getName().trim().isEmpty()) {
            throw new InvalidInputException("El correo no puede estar vacío.");
        }
    }

    private void validateNit(RestaurantModel restaurantModel){
        if (restaurantModel.getNit() == null || restaurantModel.getNit().trim().isEmpty()) {
            throw new InvalidInputException("El NIT no puede estar vacío.");
        } else if (!restaurantModel.isNit()) {
            throw new InvalidInputException("El NIT debe contener solo caracteres numéricos");
        }
    }

    private void validateAddress(RestaurantModel restaurantModel){
        if (restaurantModel.getAddress() == null || restaurantModel.getAddress().trim().isEmpty()) {
            throw new InvalidInputException("La dirección no puede estar vacía.");
        }
    }

    private void validatePhone(RestaurantModel restaurantModel){
        if (restaurantModel.getPhone() == null || restaurantModel.getPhone().trim().isEmpty()) {
            throw new InvalidInputException("El teléfono no puede estar vacío.");
        } else if (!restaurantModel.isPhone()) {
            throw new InvalidInputException("Ingresa el telefono del restaurante correctamente.");
        }
    }

    private void validateUrlLogo(RestaurantModel restaurantModel){
        if (restaurantModel.getUrlLogo() == null || restaurantModel.getUrlLogo().trim().isEmpty()) {
            throw new InvalidInputException("La URL del logo no puede estar vacía.");
        }
    }

    private void validateIdOwner(RestaurantModel restaurantModel) {
        if (restaurantModel.getIdOwner() == null || restaurantModel.toString().trim().isEmpty()) {
            throw new InvalidInputException("El ID del propietario no puede estar vacío.");
        }
    }

}