package by.nyurush.pet.service;

import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;

import java.util.List;

public interface PetService {
    
    List<Pet> findAll();

    List<Cat> findAllCats();

    List<Dog> findAllDogs();

    Pet findById(Long id);

    List<Pet> findAllByUser(Long userId);

    void save(Pet pet);

    void delete(Long id);
}
