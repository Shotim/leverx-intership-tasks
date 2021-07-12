package by.nyurush.pet.factory;

import by.nyurush.pet.service.PetService;
import by.nyurush.pet.service.UserService;
import by.nyurush.pet.service.impl.PetServiceImpl;
import by.nyurush.pet.service.impl.UserServiceImpl;

public class BeanFactory {

    private static final UserService userService = new UserServiceImpl();
    private static final PetService petService = new PetServiceImpl();

    public static UserService getUserService() {
        return userService;
    }

    public static PetService getPetService() {
        return petService;
    }

}
