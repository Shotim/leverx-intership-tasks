package by.nyurush.pet.controller;

import by.nyurush.pet.dto.UserDto;
import by.nyurush.pet.entity.User;
import by.nyurush.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> users = userService.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return modelMapper.map(userService.findById(id), UserDto.class);
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userService.save(user), UserDto.class);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userService.save(user), UserDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
