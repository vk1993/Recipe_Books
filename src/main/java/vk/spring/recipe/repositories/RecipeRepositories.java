package vk.spring.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import vk.spring.recipe.domain.Recipe;

import java.util.Optional;

public interface RecipeRepositories extends CrudRepository<Recipe,Long> {




}
