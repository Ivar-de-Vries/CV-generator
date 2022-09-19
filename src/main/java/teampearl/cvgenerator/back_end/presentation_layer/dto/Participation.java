package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teampearl.cvgenerator.back_end.presentation_layer.exceptions.DateIsInFutureException;
import teampearl.cvgenerator.back_end.presentation_layer.exceptions.EndDatePastBeginDateException;

import java.time.LocalDate;

public class Participation {
    @JsonProperty("beginDate")
    private LocalDate beginDate;

    @JsonProperty("endDate")
    private LocalDate endDate;


    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        checkDateIsNotInFuture(beginDate);
        this.beginDate = beginDate;
        checkEndDatePastBeginDateException();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        checkDateIsNotInFuture(endDate);
        this.endDate = endDate;
        checkEndDatePastBeginDateException();
    }

    private void checkDateIsNotInFuture(LocalDate date) {
        LocalDate localDate = LocalDate.now();
        if (date.isAfter(localDate)) {
            throw new DateIsInFutureException();
        }
    }

    private void checkEndDatePastBeginDateException() {
        if(beginDate == null | endDate == null)
            return;

        if(beginDate.isAfter(endDate))
            throw new EndDatePastBeginDateException();
    }
}
