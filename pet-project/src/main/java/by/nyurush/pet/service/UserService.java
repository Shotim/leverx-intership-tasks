package by.nyurush.pet.service;

import by.nyurush.pet.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User save(User user);

    void delete(Long id);
}
