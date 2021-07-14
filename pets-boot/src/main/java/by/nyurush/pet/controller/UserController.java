package by.nyurush.pet.controller;

import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.service.PetService;
import by.nyurush.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PetService petService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable final Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody final User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable final Long id,
                              @RequestBody final User user) {
        user.setId(id);
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/{id}/pets")
    public List<Pet> findAllPetsByUser(@PathVariable final Long id) {
        return petService.findAllByUserId(id);
    }

}
