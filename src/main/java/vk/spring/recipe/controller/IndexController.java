package vk.spring.recipe.controller;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import vk.spring.recipe.domain.Recipe;
        import vk.spring.recipe.service.RecipeService;

        import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());
        model.addAttribute("page_title","Recipes");
        log.debug("Adding Model Attribute and Sending view");
        return "index";
    }
}
