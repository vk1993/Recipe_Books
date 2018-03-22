package vk.spring.recipe.bootstrap;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.context.ApplicationListener;
        import org.springframework.context.event.ContextRefreshedEvent;
        import org.springframework.stereotype.Component;
        import org.springframework.transaction.annotation.Transactional;
        import vk.spring.recipe.domain.*;
        import vk.spring.recipe.repositories.CategoryRepositories;
        import vk.spring.recipe.repositories.RecipeRepositories;
        import vk.spring.recipe.repositories.UnitOfMeasureRepositories;

        import javax.management.monitor.GaugeMonitor;
        import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;


        @Slf4j
        @Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private CategoryRepositories categoryRepositories;
    private RecipeRepositories recipeRepositories;
    private UnitOfMeasureRepositories unitOfMeasureRepositories;

    public RecipeBootstrap(CategoryRepositories categoryRepositories, RecipeRepositories recipeRepositories, UnitOfMeasureRepositories unitOfMeasureRepositories) {

        this.categoryRepositories = categoryRepositories;
        this.recipeRepositories = recipeRepositories;
        this.unitOfMeasureRepositories = unitOfMeasureRepositories;
    }
            @Override
            @Transactional
            public void onApplicationEvent(ContextRefreshedEvent event) {
                log.debug("Inside onApllication Event");
                recipeRepositories.saveAll(getRecipes());
            }


    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(3);

        Optional<UnitOfMeasure> eachUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Each");
//optional just for experiment

        eachUnitOfMeasureOptional.ifPresent(unitOfMeasure -> {
            System.out.println(unitOfMeasure.getDescription());
            System.out.println(unitOfMeasure.hashCode());
        });

        if(!eachUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }

        Optional<UnitOfMeasure> tableSpoonUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Tablespoon");

        if(!tableSpoonUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }
        Optional<UnitOfMeasure> teaSpoonUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Teaspoon");

        if(!teaSpoonUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }
        Optional<UnitOfMeasure> cupUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Cup");

        if(!cupUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }
        Optional<UnitOfMeasure> pinchUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Pinch");

        if(!pinchUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }
        Optional<UnitOfMeasure> ounceUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Ounce");

        if(!ounceUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        } Optional<UnitOfMeasure> smallUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Small");

        if(!smallUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }

        Optional<UnitOfMeasure> mediumUnitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Medium");

        if(!mediumUnitOfMeasureOptional.isPresent()){
            throw new RuntimeException("Expected --UOM-- not found");
        }


        UnitOfMeasure eachUOM = eachUnitOfMeasureOptional.get();
        UnitOfMeasure tablespoonUOM =tableSpoonUnitOfMeasureOptional.get();
        UnitOfMeasure smallUOM = smallUnitOfMeasureOptional.get();
        UnitOfMeasure mediumUOM = mediumUnitOfMeasureOptional.get();
        UnitOfMeasure ounceUOM = ounceUnitOfMeasureOptional.get();
        UnitOfMeasure  pinchUOM= pinchUnitOfMeasureOptional.get();
        UnitOfMeasure cupUOM = cupUnitOfMeasureOptional.get();
        UnitOfMeasure  teaspoonUOM= teaSpoonUnitOfMeasureOptional.get();


        Optional<Category> southIndianCategoryOptional = categoryRepositories.findByDescription("South Indian");
        if(!southIndianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> northIndianCategoryOptional = categoryRepositories.findByDescription("North Indian");

        if(!northIndianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category southIndianCategory = southIndianCategoryOptional.get();
        Category northIndCategory = northIndianCategoryOptional.get();

        Recipe Guacamole = new Recipe();
        Guacamole.setDescription("Perfect Guacamole");
        Guacamole.setPrepTime(10);
        Guacamole.setCookTime(8);
        Guacamole.setDifficulty(Difficulty.MODERATE);
        Guacamole.setDirection("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "\n"+
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +"\n"+
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown." +
                "\n"+"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness." +
                "\n"+"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "\n"+"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve." +
                "\n"+"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."
        );
        Guacamole.setServing(10);
        Guacamole.setUrl("www.google.com/guava.com");
        Notes guacanote = new Notes();
        guacanote.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole)." +
                "\n"+"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");


        Guacamole.setNotes(guacanote);

        Guacamole.addIngredient(new Ingredient("Ripe Avgado",new BigDecimal(3),eachUOM));
        Guacamole.addIngredient(new Ingredient("teaspoon Kosher salt",new BigDecimal(2),teaspoonUOM));
        Guacamole.addIngredient(new Ingredient(" Tbsp of fresh lime juice or lemon juice",new BigDecimal(2),tablespoonUOM));
        Guacamole.addIngredient(new Ingredient(" serrano chiles, stems and seeds removed, minced",new BigDecimal(2),eachUOM));

        Guacamole.getCategories().add(southIndianCategory);
        Guacamole.getCategories().add(northIndCategory);

//adding Guacamole to RECIPE object
        recipes.add(Guacamole);

        //Veggie Tacos Recipe
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Veggie Tacos Recipe");
        tacosRecipe.setUrl("www.google.comklskjsh");
        tacosRecipe.setServing(6);
        tacosRecipe.setCookTime(10);
        tacosRecipe.setDifficulty(Difficulty.HARD);
        tacosRecipe.setPrepTime(66);
        tacosRecipe.setDirection("1 Heat a tablespoon or two of oil in a large sauté pan on medium high heat. Add the zucchini, onions, garlic, green chiles, and jalapeño to the pan. Sprinkle with salt and cumin. Stir to coat the vegetables with the oil in the pan." +
                " Spread the veggies out in the pan and then stir only occasionally, " +
                "until they are all lightly browned. Stir in the chopped tomatoes and oregano, " +
                "lower the heat to low. Let gently cook for several minutes while you are preparing the tortillas.\n" +
                "You are going to want to heat up the tortillas first, first to soften them, and then to melt the cheese." +
                "There are two basic ways of doing this. One way is on the stove top, preferably in a cast iron pan." +
                "Another way is to use the microwave. In both methods you will work in batches.\n" +
                "(A third way is to use fresh homemade corn tortillas, " +
                "which is a great option if you are set up for it.)");
        Notes tacosNote = new Notes();
        tacosNote.setRecipeNotes("2b Preparing tortillas in the microwave Place a paper towel (or half a paper towel) on the heating surface of your microwave. Spread out 2 tortillas on the paper towels. " +
                "Cook on high heat for 20 seconds per tortilla, in the case of 2 tortillas, 40 seconds. The tortillas should develop air pockets. " +
                "(Note that every microwave is a little different, and corn tortillas differ as well. So you may need to adjust the times for your particular setup.) " +
                "Then place a slice of cheese on one side of each tortilla and fold the tortillas over the cheese." +
                "Cook for an additional 10 seconds per tortilla (20 seconds for 2 tortillas), or until the cheese is melted.");

        tacosRecipe.setNotes(tacosNote);


        tacosRecipe.getCategories().add(northIndCategory);

        tacosRecipe.addIngredient(new Ingredient( " roughly chopped zucchini or summer squash ",new BigDecimal(1),cupUOM));
        tacosRecipe.addIngredient(new Ingredient("medium onion, chopped",new BigDecimal(1.5),smallUOM));
        tacosRecipe.addIngredient(new Ingredient( "garlic clove, chopped" ,new BigDecimal(1),eachUOM));
        tacosRecipe.addIngredient(new Ingredient("Pinch of ground cumin",new BigDecimal(1),pinchUOM));
        tacosRecipe.addIngredient(new Ingredient(" small to medium tomato, chopped",new BigDecimal(1),smallUOM));
        tacosRecipe.addIngredient(new Ingredient("slices cheddar cheese",new BigDecimal(4),mediumUOM));

      recipes.add(tacosRecipe);

        return recipes;
    }



}
