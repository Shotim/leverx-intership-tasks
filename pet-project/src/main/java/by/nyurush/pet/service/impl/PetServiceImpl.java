package by.nyurush.pet.service.impl;

import by.nyurush.pet.dao.PetDao;
import by.nyurush.pet.dao.UserDao;
import by.nyurush.pet.dao.impl.PetDaoImpl;
import by.nyurush.pet.dao.impl.UserDaoImpl;
import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.EntityNotFoundException;
import by.nyurush.pet.service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {

    private static final PetDao petDao = new PetDaoImpl();
    private static final UserDao userDao = new UserDaoImpl();

    @Override
    public List<Pet> findAll() {
        return petDao.findAll();
    }

    @Override
    public List<Cat> findAllCats() {
        return petDao.findAllCats();
    }

    @Override
    public List<Dog> findAllDogs() {
        return petDao.findAllDogs();
    }

    @Override
    public Pet findById(Long id) {
        return petDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Pet with id " + id + " not found."
                ));
    }

    @Override
    public List<Pet> findAllByUser(Long userId) {
        User user = userDao.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + userId + " not found"
                ));
        return petDao.findAllByUser(user);
    }

    @Override
    public void save(Pet pet) {
        petDao.save(pet);
    }

    @Override
    public void delete(Long id) {
        Pet pet = petDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + id + " not found"
                ));
        petDao.delete(pet);
    }
}
