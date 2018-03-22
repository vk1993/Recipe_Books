package vk.spring.recipe.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import vk.spring.recipe.domain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoriesIT {

    @Autowired
    UnitOfMeasureRepositories unitOfMeasureRepositories;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByDescription() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Cup");
        assertEquals("Cup",unitOfMeasureOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionEach() {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepositories.findByDescription("Each");
        assertEquals("Each",unitOfMeasureOptional.get().getDescription());
    }
}