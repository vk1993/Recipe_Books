package vk.spring.recipe.service;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Service;
        import vk.spring.recipe.domain.Recipe;
        import vk.spring.recipe.repositories.RecipeRepositories;

        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService{

    private final RecipeRepositories recipeRepositories ;

    public RecipeServiceImp(RecipeRepositories recipeRepositories) {
        this.recipeRepositories = recipeRepositories;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipeList = new HashSet<>();
        recipeRepositories.findAll().iterator().forEachRemaining(recipeList :: add);
        log.debug("Implimetation method of getRecipe and returing reipeLIST......");
        return recipeList;
    }
}
