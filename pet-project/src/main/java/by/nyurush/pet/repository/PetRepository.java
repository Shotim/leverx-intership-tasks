package by.nyurush.pet.repository;

import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Pet save(Pet pet);

    void delete(Pet pet);

    List<Pet> findAll();

    Optional<Pet> findById(Long id);

    List<Cat> findAllCats();

    List<Dog> findAllDogs();

    List<Pet> findAllByUser(User user);
}
