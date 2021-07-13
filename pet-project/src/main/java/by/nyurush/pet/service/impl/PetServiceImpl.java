package by.nyurush.pet.service.impl;

import by.nyurush.pet.repository.PetRepository;
import by.nyurush.pet.repository.UserRepository;
import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.EntityNotFoundException;
import by.nyurush.pet.service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public PetServiceImpl(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<Cat> findAllCats() {
        return petRepository.findAllCats();
    }

    @Override
    public List<Dog> findAllDogs() {
        return petRepository.findAllDogs();
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Pet with id " + id + " not found."
                ));
    }

    @Override
    public List<Pet> findAllByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + userId + " not found"
                ));
        return petRepository.findAllByUser(user);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + id + " not found"
                ));
        petRepository.delete(pet);
    }
}
