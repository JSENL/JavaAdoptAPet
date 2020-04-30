package com.adoptapet.repositories;
import com.adoptapet.models.PetType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypesRepository extends PagingAndSortingRepository<PetType, Integer> {

}
