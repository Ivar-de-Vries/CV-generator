package teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import teampearl.cvgenerator.back_end.data_access_layer.entities.IEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbstractWithEmployeeControllerTest {
    private static final int EMPLOYEE_ID = 3;

    AbstractWithEmployeeController<IEntity, Object> sut;
    JpaRepository<IEntity, Object> jpaRepositoryTest;
    IEntity expectedEntity;
    Object expectedDTO;

    @BeforeEach
    void setUp() {
        jpaRepositoryTest = mock(JpaRepository.class);
        sut = mock(AbstractWithEmployeeController.class, Mockito.withSettings().useConstructor(jpaRepositoryTest).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        expectedEntity = mock(IEntity.class);
        expectedDTO = new Object();
    }

    @Test
    void readEntitiesWithEmployeeIdShouldReturnResponseHTTPOkWithDTOs() {
        //Arrange
        List<Object> expectedList = new ArrayList<>();
        expectedList.add(expectedDTO);
        List<IEntity> expectedEntities = new ArrayList<>();
        expectedEntities.add(expectedEntity);
        var expectedValue = ResponseEntity.ok(expectedList);
        when(sut.readAllEmployee(EMPLOYEE_ID)).thenReturn(expectedEntities);
        when(sut.entitiesToDTOs(expectedEntities)).thenReturn(expectedList);
        //ACT
        var result = sut.readEntitiesWithEmployeeId(EMPLOYEE_ID);

        //ASSERT
        Assertions.assertEquals(expectedValue, result);
    }
}
