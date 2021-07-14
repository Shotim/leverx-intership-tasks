package by.nyurush.pet.service.impl;

import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.CatBreed;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.DogBreed;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.repository.CatRepository;
import by.nyurush.pet.repository.DogRepository;
import by.nyurush.pet.repository.PetRepository;
import by.nyurush.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final CatRepository catRepository;
    private final DogRepository dogRepository;

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(EntityExistsException::new);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    @Override
    public List<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public List<Cat> findAllCatsByCatBreed(CatBreed catBreed) {
        return catRepository.findAllByCatBreed(catBreed);
    }

    @Override
    public List<Dog> findAllDogsByCatBreed(DogBreed dogBreed) {
        return dogRepository.findAllByDogBreed(dogBreed);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

}
