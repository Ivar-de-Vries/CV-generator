package teampearl.cvgenerator.back_end.presentation_layer.exception_handling;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.hibernate.PropertyValueException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private Logger logger;

    public RestResponseEntityExceptionHandler() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    @ExceptionHandler({ SQLServerException.class })
    public ResponseEntity<Object> handleSQLServerException(SQLServerException ex) {
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        // Duplicate Key
        if(ex.getErrorCode() == 2627) {
            String bodyOfResponse = "Duplicate key: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(bodyOfResponse);
        }
        else {
            String bodyOfResponse = "Internal Server Error check the logs.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bodyOfResponse);
        }
    }

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleIllegalConflict(
            RuntimeException ex, WebRequest request) {
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {EmptyResultDataAccessException.class, NullPointerException.class} )
    public ResponseEntity<Object> handleEmptyResultDataAccessException(RuntimeException ex){
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        String bodyOfResponse = "Invalid input: no data could be found in database";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        String bodyOfResponse = "Invalid input: No entity was found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Object> handlePropertyValueException(PropertyValueException ex){
        logger.log(Level.SEVERE, ex.getMessage(), ex);
        String bodyOfResponse = "Invalid input: Value of '"+ ex.getPropertyName() + "' is not valid";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyOfResponse);
    }
}
