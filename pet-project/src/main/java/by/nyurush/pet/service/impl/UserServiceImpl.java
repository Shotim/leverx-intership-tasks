package by.nyurush.pet.service.impl;

import by.nyurush.pet.repository.UserRepository;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.EntityNotFoundException;
import by.nyurush.pet.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + id + " not found.")
                );
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with id " + id + " not found.")
        );
        userRepository.delete(user);
    }
}
