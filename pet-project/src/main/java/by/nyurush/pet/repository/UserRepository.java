package by.nyurush.pet.repository;

import by.nyurush.pet.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    Optional<User> findById(Long id);
}
