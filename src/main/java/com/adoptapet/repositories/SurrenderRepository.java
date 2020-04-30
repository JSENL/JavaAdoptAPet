package com.adoptapet.repositories;
import com.adoptapet.models.PetSurrender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurrenderRepository extends PagingAndSortingRepository<PetSurrender, Integer> {
}