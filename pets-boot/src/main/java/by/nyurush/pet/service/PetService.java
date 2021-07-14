package by.nyurush.pet.service;

import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.CatBreed;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.DogBreed;
import by.nyurush.pet.entity.Pet;

import java.util.List;

public interface PetService {
    Pet findById(Long id);
    List<Pet> findAll();
    List<Cat> findAllCats();
    List<Dog> findAllDogs();
    List<Cat> findAllCatsByCatBreed(CatBreed catBreed);
    List<Dog> findAllDogsByCatBreed(DogBreed dogBreed);
    Pet save(Pet pet);
    void deleteById(Long id);
}
