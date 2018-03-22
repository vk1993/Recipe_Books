package vk.spring.recipe.controller;

        import org.junit.Before;
        import org.junit.Test;
        import org.mockito.*;
        import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
        import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.MockMvcBuilder;
        import org.springframework.test.web.servlet.setup.MockMvcBuilders;
        import org.springframework.ui.Model;
        import vk.spring.recipe.domain.Recipe;
        import vk.spring.recipe.service.RecipeService;


        import java.util.HashSet;
        import java.util.Set;

        import static org.junit.Assert.*;
        import static org.mockito.Mockito.*;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {

    RecipeController recipeController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {

        Set<Recipe> recipes = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(2L);

        Recipe recipe2 = new Recipe();
        recipe2.setId(22L);
        recipes.add(recipe1);
        recipes.add(recipe2);
        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> setArgumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = recipeController.getIndexPage(model);
        assertEquals("index", viewName);
       verify(recipeService,times(1)).getRecipes();
       //for single time if the method is called then we should use this.
        verify(model,times(1)).addAttribute(eq("recipes"),setArgumentCaptor.capture());
    }
}