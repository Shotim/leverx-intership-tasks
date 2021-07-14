package by.nyurush.pet.dto;

import by.nyurush.pet.entity.DogBreed;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DogDto extends PetDto {

    private DogBreed dogBreed;
}
