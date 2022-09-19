package teampearl.cvgenerator.back_end.presentation_layer.exception_handling;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RestResponseEntityExceptionHandlerTest {
    RestResponseEntityExceptionHandler sut;

    @BeforeEach
    void setup() {
        sut = new RestResponseEntityExceptionHandler();
    }

    @Test
    void handleSQLServerExceptionReturnsDuplicateKey() {
        // ARRANGE
        var ex = Mockito.mock(SQLServerException.class);
        Mockito.when(ex.getErrorCode()).thenReturn(2627);
        String bodyOfResponse = "Duplicate key: " + ex.getMessage();
        // ACT
        var body = sut.handleSQLServerException(ex);
        // ASSERT
        assertEquals(ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOfResponse), body);
    }

    @Test
    void transformSQLServerExceptionToExceptionsReturnsInternalServerError() {
        // ARRANGE
        var ex = Mockito.mock(SQLServerException.class);
        Mockito.when(ex.getErrorCode()).thenReturn(0);
        String bodyOfResponse = "Internal Server Error check the logs.";
        // ACT
        var body = sut.handleSQLServerException(ex);
        // ASSERT
        assertEquals(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyOfResponse), body);
    }

    @Test
    void testHandleConflictIllegalArgumentException() {
        // ARRANGE
        var ex = new IllegalArgumentException();
        String bodyOfResponse = "This should be application specific";
        // ACT
        var body = sut.handleIllegalConflict(ex, null);
        // ASSERT
        assertEquals(ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOfResponse), body);
    }

    @Test
    void testHandleEmptyResultDataAccessException() {
        // ARRANGE
        var ex = new EmptyResultDataAccessException(2);
        String bodyOfResponse = "Invalid input: no data could be found in database";
        // ACT
        var body = sut.handleEmptyResultDataAccessException(ex);
        // ASSERT
        assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse), body);
    }

    @Test
    void testHandleEntityNotFoundException() {
        // ARRANGE
        var ex = new EntityNotFoundException();
        String bodyOfResponse = "Invalid input: No entity was found";
        // ACT
        var body = sut.handleEntityNotFoundException(ex);
        // ASSERT
        assertEquals(ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse), body);
    }
}