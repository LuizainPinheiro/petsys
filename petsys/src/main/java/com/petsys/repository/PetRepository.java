package com.petsys.repository;

import com.petsys.model.Pet;
import com.petsys.model.PetCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByCategoria(PetCategoria categoria);

    List<Pet> findByNomeContainingIgnoreCase(String nome);

}
