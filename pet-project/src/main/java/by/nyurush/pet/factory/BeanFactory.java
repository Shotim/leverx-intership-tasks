package by.nyurush.pet.factory;

import by.nyurush.pet.repository.PetRepository;
import by.nyurush.pet.repository.UserRepository;
import by.nyurush.pet.repository.impl.PetRepositoryImpl;
import by.nyurush.pet.repository.impl.UserRepositoryImpl;
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
        UserRepository userRepository = new UserRepositoryImpl();
        PetRepository petRepository = new PetRepositoryImpl();
        userService = new UserServiceImpl(userRepository);
        petService = new PetServiceImpl(
                petRepository, userRepository
        );
    }

    public static UserService getUserService() {
        return userService;
    }

    public static PetService getPetService() {
        return petService;
    }


}
