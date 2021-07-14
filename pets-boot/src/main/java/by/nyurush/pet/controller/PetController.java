package by.nyurush.pet.controller;

import by.nyurush.pet.dto.PetAdapter;
import by.nyurush.pet.entity.Cat;
import by.nyurush.pet.entity.Dog;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.service.PetService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping
    public List<Pet> findAllPets() {
        return petService.findAll();
    }

    @GetMapping("/cats")
    public List<Cat> findAllCats() {
        return petService.findAllCats();
    }

    @GetMapping("/dogs")
    public List<Dog> findAllDogs() {
        return petService.findAllDogs();
    }

    @GetMapping("/{id}")
    public Pet findPetById(@PathVariable Long id) {
        return petService.findById(id);
    }

    @PostMapping
    public Pet savePet(@RequestBody Object pet) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Pet.class, new PetAdapter())
                .create();
        String jsonPet = gson.toJson(pet);

        Pet petToSave = gson.fromJson(jsonPet, Pet.class);
        return petService.save(petToSave);
    }

    @PutMapping ("/{id}")
    public Pet updatePet(@PathVariable Long id,
                         @RequestBody Object pet) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Pet.class, new PetAdapter())
                .create();
        String jsonPet = gson.toJson(pet);

        Pet petToSave = gson.fromJson(jsonPet, Pet.class);
        petToSave.setId(id);
        return petService.save(petToSave);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deleteById(id);
    }


}
