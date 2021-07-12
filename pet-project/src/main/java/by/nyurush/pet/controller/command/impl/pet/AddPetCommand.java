package by.nyurush.pet.controller.command.impl.pet;

import by.nyurush.pet.controller.command.Command;
import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.PetAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.nyurush.pet.factory.BeanFactory.getPetService;

public class AddPetCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String jsonString = IOUtils.toString(req.getInputStream());
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Pet.class, new PetAdapter())
                    .create();

            Pet pet = gson.fromJson(jsonString, Pet.class);
            String path = req.getRequestURI();
            if (path.matches("^.*\\d$")) {
                String id = path.substring(path.lastIndexOf('/') + 1);
                pet.setId(Long.parseLong(id));
            }

            getPetService().save(pet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
