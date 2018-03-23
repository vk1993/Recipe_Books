package vk.spring.recipe.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import vk.spring.recipe.domain.Recipe;
import vk.spring.recipe.repositories.RecipeRepositories;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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
        verify(recipeRepositories,times(1)).findAll();
        verify(recipeRepositories,never()).findById(anyLong());
    }

    @Test
    public void findById() {
        Recipe recipe =  new Recipe();
        recipe.setId(1l);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepositories.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeServiceImp.findById(1l);
        assertNotNull("Null recipe return",recipeReturned);
        verify(recipeRepositories,times(1)).findById(anyLong());
        verify(recipeRepositories,never()).findAll();
    }
}