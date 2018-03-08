package vk.spring.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vk.spring.recipe.domain.Recipe;

public interface RecipeRepositories extends CrudRepository<Recipe,Long> {
}
