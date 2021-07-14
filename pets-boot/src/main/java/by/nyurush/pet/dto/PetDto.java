package by.nyurush.pet.dto;

import lombok.Data;

@Data
public class PetDto {

    protected Long id;

    protected String name;

    protected Integer age;

    private Long userId;
}
