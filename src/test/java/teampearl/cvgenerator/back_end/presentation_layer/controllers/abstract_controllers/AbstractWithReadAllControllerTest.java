package teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import teampearl.cvgenerator.back_end.data_access_layer.entities.IEntity;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractWithReadAllControllerTest {
    private static final int ENTITY_ID = 3;

    AbstractWithReadAllController<IEntity, Object> sut;
    JpaRepository<IEntity, Object> jpaRepositoryTest;
    IEntity expectedEntity;
    Object expectedDTO;

    @BeforeEach
    void setUp() {
        jpaRepositoryTest = mock(JpaRepository.class);
        sut = mock(AbstractWithReadAllController.class, Mockito.withSettings().useConstructor(jpaRepositoryTest).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        expectedEntity = mock(IEntity.class);
        expectedDTO = new Object();
        when(sut.dtoToEntity(expectedDTO)).thenReturn(expectedEntity);
        when(sut.entityToDTO(expectedEntity)).thenReturn(expectedDTO);
    }

    @Test
    void readEntitiesShouldReturnResponseHTTPOkWithDTOs() {
        //Arrange
        List<Object> expectedList = new ArrayList<>();
        expectedList.add(expectedDTO);
        List<IEntity> expectedEntities = new ArrayList<>();
        expectedEntities.add(expectedEntity);
        var expectedValue = ResponseEntity.ok(expectedList);
        when(jpaRepositoryTest.findAll()).thenReturn(expectedEntities);
        when(sut.entitiesToDTOs(expectedEntities)).thenReturn(expectedList);
        //ACT
        var result = sut.readEntities();

        //ASSERT
        Assertions.assertEquals(expectedValue, result);
    }
}
