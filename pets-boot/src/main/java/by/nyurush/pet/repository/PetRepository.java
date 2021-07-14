package by.nyurush.pet.repository;

import by.nyurush.pet.entity.Pet;
import by.nyurush.pet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository
        extends JpaRepository<Pet, Long> {

    List<Pet> findAllByUser_Id(Long userId);
}
