package by.nyurush.pet.dto;

import by.nyurush.pet.entity.CatBreed;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CatDto extends PetDto {

//    @JsonCreator
//    public CatDto(
//            @JsonProperty(value = "id") Long id,
//            @JsonProperty(value = "name") String name,
//            @JsonProperty(value = "age") Integer age,
//            @JsonProperty(value = "userId") Long userId,
//            @JsonProperty(value = "catBreed") CatBreed catBreed
//    ) {
//        super(id, name, age, userId);
//        this.catBreed = catBreed;
//    }

    private CatBreed catBreed;
}
