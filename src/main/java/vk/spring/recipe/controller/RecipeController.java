package vk.spring.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vk.spring.recipe.domain.Recipe;
import vk.spring.recipe.service.RecipeService;

import javax.websocket.server.PathParam;

@Controller
public class RecipeController {

    @Autowired
   private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
       this.recipeService = recipeService;
   }
    @RequestMapping("/recipe/show/{id}")
    public String getRecipe( @PathVariable String id, Model model){

               model.addAttribute("recipe",recipeService.findById(new Long(id)));

        return "recipe/show";
    }
}
