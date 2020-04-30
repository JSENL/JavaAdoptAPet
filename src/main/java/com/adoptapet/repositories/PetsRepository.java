package com.adoptapet.repositories;
import com.adoptapet.models.Pet;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends PagingAndSortingRepository<Pet, Integer> {

}
