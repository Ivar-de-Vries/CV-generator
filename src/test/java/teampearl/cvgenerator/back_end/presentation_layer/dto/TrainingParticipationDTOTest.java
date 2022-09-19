package teampearl.cvgenerator.back_end.presentation_layer.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teampearl.cvgenerator.back_end.presentation_layer.exceptions.DateIsInFutureException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingParticipationDTOTest {

    TrainingParticipationDTO sut;
    LocalDate futureTest = LocalDate.now().plusMonths(3);
    LocalDate pastTest = LocalDate.now().minusWeeks(10);

    @BeforeEach
    void setup() {
        sut = new TrainingParticipationDTO();
    }

    @Test
    public void begindateisinfutureshoulderrorTest() {
        //ARRANGE
        //ACT en ASSERT
        Assertions.assertThrows(DateIsInFutureException.class,()-> sut.setBeginDate(futureTest) ) ;
    }

    @Test
    public void endateisinfutureshoulderrorTest() {
        //ARRANGE
        //ACT en ASSERT
        Assertions.assertThrows(DateIsInFutureException.class,()-> sut.setEndDate(futureTest));
    }

    @Test
    public void begindateisinfutureshouldpassTest() {
        //ARRANGE
        //ACT
        sut.setBeginDate(pastTest);
        //ASSERT
        assertEquals(pastTest, sut.getBeginDate());
    }

    @Test
    public void enddateisinfutureshouldpassTest() {
        //ARRANGE
        //ACT
        sut.setEndDate(pastTest);
        //ASSERT
        assertEquals(pastTest, sut.getEndDate());
    }

}