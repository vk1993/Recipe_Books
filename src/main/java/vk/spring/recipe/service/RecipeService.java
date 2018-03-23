package vk.spring.recipe.service;

import org.springframework.stereotype.Service;
import vk.spring.recipe.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
}
