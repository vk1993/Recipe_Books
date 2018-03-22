package vk.spring.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vk.spring.recipe.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepositories extends CrudRepository<UnitOfMeasure,Long> {

     Optional<UnitOfMeasure> findByDescription(String Description);
}
