package by.nyurush.pet.service.impl;

import by.nyurush.pet.dao.UserDao;
import by.nyurush.pet.dao.impl.UserDaoImpl;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.exception.EntityNotFoundException;
import by.nyurush.pet.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User findById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "User with id " + id + " not found.")
                );
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userDao.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User with id " + id + " not found.")
        );
        userDao.delete(user);
    }
}
