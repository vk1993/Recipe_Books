package vk.spring.recipe.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import vk.spring.recipe.domain.Recipe;
import vk.spring.recipe.repositories.RecipeRepositories;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class RecipeServiceImpTest {

    RecipeServiceImp recipeServiceImp;
    @Mock
    RecipeRepositories recipeRepositories;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        recipeServiceImp = new RecipeServiceImp(recipeRepositories);
    }

    @Test
    public void getRecipes() {

        Recipe recipe =  new Recipe();

        HashSet recipHashSet = new HashSet();
        recipHashSet.add(recipe);

        when(recipeServiceImp.getRecipes()).thenReturn(recipHashSet);

        Set<Recipe> recipes = recipeServiceImp.getRecipes();
        System.out.println(recipes.toString());
        assertEquals(recipes.size(),1);
    }
}