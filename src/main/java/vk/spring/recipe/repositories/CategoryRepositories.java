package vk.spring.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vk.spring.recipe.domain.Category;

import java.util.Optional;

public interface CategoryRepositories extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String description);
    Optional<Category> findById(Long id);
}
