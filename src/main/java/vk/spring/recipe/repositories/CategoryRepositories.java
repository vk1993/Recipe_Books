package vk.spring.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vk.spring.recipe.domain.Category;

public interface CategoryRepositories extends CrudRepository<Category,Long> {
}
