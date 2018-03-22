package vk.spring.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
       category =new Category();
    }

    @Test
    public void getId() {
        Long cid = 4L;
        category.setId(cid);
         assertEquals(cid,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}