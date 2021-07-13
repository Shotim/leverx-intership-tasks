package by.nyurush.pet.factory;

import by.nyurush.pet.dao.PetDao;
import by.nyurush.pet.dao.UserDao;
import by.nyurush.pet.dao.impl.PetDaoImpl;
import by.nyurush.pet.dao.impl.UserDaoImpl;
import by.nyurush.pet.service.PetService;
import by.nyurush.pet.service.UserService;
import by.nyurush.pet.service.impl.PetServiceImpl;
import by.nyurush.pet.service.impl.UserServiceImpl;

public class BeanFactory {
    private static final UserService userService;
    private static final PetService petService;

    private BeanFactory() {

    }

    static {
        UserDao userDao = new UserDaoImpl();
        PetDao petDao = new PetDaoImpl();
        userService = new UserServiceImpl(userDao);
        petService = new PetServiceImpl(
                petDao, userDao
        );
    }

    public static UserService getUserService() {
        return userService;
    }

    public static PetService getPetService() {
        return petService;
    }


}
