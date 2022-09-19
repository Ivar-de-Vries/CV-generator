package teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import teampearl.cvgenerator.back_end.data_access_layer.entities.IEntity;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AbstractControllerTest{
    private static final int ENTITY_ID = 3;

    AbstractController<IEntity, Object> sut;
    JpaRepository<IEntity, Object> jpaRepositoryTest;
    IEntity expectedEntity;
    Object expectedDTO;

    @BeforeEach
    void setUp() {
        jpaRepositoryTest = mock(JpaRepository.class);
        sut = mock(AbstractController.class, Mockito.withSettings().useConstructor(jpaRepositoryTest).defaultAnswer(Mockito.CALLS_REAL_METHODS));
        expectedEntity = mock(IEntity.class);
        expectedDTO = new Object();
        when(sut.dtoToEntity(expectedDTO)).thenReturn(expectedEntity);
        when(sut.entityToDTO(expectedEntity)).thenReturn(expectedDTO);
    }

    @Test
    void readEntityShouldReturnResponseHttpOkWithDTO() {
        //Arrange
        var expectedValue = ResponseEntity.ok(expectedDTO);
        when(jpaRepositoryTest.findById(ENTITY_ID)).thenReturn(Optional.of(expectedEntity));

        //Act
        var result = sut.readEntity(ENTITY_ID);

        //Assert
        Mockito.verify(sut).entityToDTO(expectedEntity);
        Mockito.verify(jpaRepositoryTest).findById(ENTITY_ID);
        Assertions.assertEquals(expectedValue, result);
    }

    @Test
    void createEntityShouldReturnCreatedWithLocation() {
        //ARRANGE
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        var expectedLoc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ENTITY_ID).toUri();
        var expectedResponse = ResponseEntity.created(expectedLoc).body(expectedDTO);
        when(jpaRepositoryTest.save(expectedEntity)).thenReturn(expectedEntity);
        when(expectedEntity.getId()).thenReturn(ENTITY_ID);
        //ACT
        var response = sut.createEntity(expectedDTO);

        //ASSERT
        Mockito.verify(sut).entityToDTO(expectedEntity);
        Mockito.verify(sut).dtoToEntity(expectedDTO);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateEntityShouldReturnResponseHTTPOkWithEntityThatExists() {
        //ARRANGE
        var expectedResponse = ResponseEntity.ok(expectedDTO);
        when(jpaRepositoryTest.existsById(ENTITY_ID)).thenReturn(true);
        when(jpaRepositoryTest.save(expectedEntity)).thenReturn(expectedEntity);

        //ACT
        var response = sut.updateEntity(expectedDTO, ENTITY_ID);
        //ASSERT
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    void deleteEntityShouldReturnResponseHTTPNoContent() {
        //ARRANGE
        var expectedResponse = ResponseEntity.noContent().build();
        //ACT
        var returnedValue = sut.deleteEntity(ENTITY_ID);
        //ASSERT
        Assertions.assertEquals(expectedResponse, returnedValue);
        verify(jpaRepositoryTest).deleteById(ENTITY_ID);
    }

    @Test
    void deleteEntityShouldNotCatchEmptyResultDataAccessException() {
        //ARRANGE
        doThrow(EmptyResultDataAccessException.class).when(jpaRepositoryTest).deleteById(ENTITY_ID);
        //ACT and ASSERT
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> sut.deleteEntity(ENTITY_ID));
        verify(jpaRepositoryTest).deleteById(ENTITY_ID);
    }

    @Test
    void updateEntityShouldNotCatchEntityNotFoundException() {
        //ARRANGE
        when(jpaRepositoryTest.existsById(ENTITY_ID)).thenReturn(false);
        when(jpaRepositoryTest.save(any())).thenReturn(expectedEntity);
        //ACT and ASSERT
        Assertions.assertThrows(EntityNotFoundException.class, () -> sut.updateEntity(expectedDTO, ENTITY_ID));
        Mockito.verify(jpaRepositoryTest, never()).save(any());
    }

    @Test
    void getEntityShouldThrowEntityNotFoundExceptionWhenEntityWasIndeedNotFound() {
        //ARRANGE
        when(jpaRepositoryTest.findById(ENTITY_ID)).thenReturn(Optional.empty());
        //Act and ASSERT
        Assertions.assertThrows(EntityNotFoundException.class, () -> sut.readEntity(ENTITY_ID));
        verify(jpaRepositoryTest).findById(ENTITY_ID);
    }

    @Test
    void createEntityShouldNotCatchDataIntegretyViolationException() {
        //ARANGE
        when(jpaRepositoryTest.save(any())).thenThrow(DataIntegrityViolationException.class);
        //Act and Assert
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> sut.createEntity(expectedDTO));
        verify(jpaRepositoryTest).save(expectedEntity);
    }
 }