package vk.spring.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {
    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        model.addAttribute("page_title","Home");
         return "index";

    }
}
