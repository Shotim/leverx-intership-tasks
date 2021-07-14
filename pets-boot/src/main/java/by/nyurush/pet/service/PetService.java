package by.nyurush.pet.service;

import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;

import java.util.List;

public interface PetService {
    Pet findById(Long id);

    List<Pet> findAll();

    List<Cat> findAllCats();

    List<Dog> findAllDogs();

    List<Pet> findAllByUserId(Long userId);

    Pet save(Pet pet);

    void deleteById(Long id);
}
