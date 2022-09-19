package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Language;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageSkill;

public class LanguageLevelDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("language")
    private LanguageDTO language;

    @JsonProperty("speakingLevel")
    private LanguageSkillDTO speakingLevel;

    @JsonProperty("readingLevel")
    private LanguageSkillDTO readingLevel;

    @JsonProperty("writingLevel")
    private LanguageSkillDTO writingLevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public LanguageDTO getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDTO language) {
        this.language = language;
    }

    public LanguageSkillDTO getSpeakingLevel() {
        return speakingLevel;
    }

    public void setSpeakingLevel(LanguageSkillDTO speakingLevel) {
        this.speakingLevel = speakingLevel;
    }

    public LanguageSkillDTO getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(LanguageSkillDTO readingLevel) {
        this.readingLevel = readingLevel;
    }

    public LanguageSkillDTO getWritingLevel() {
        return writingLevel;
    }

    public void setWritingLevel(LanguageSkillDTO writingLevel) {
        this.writingLevel = writingLevel;
    }
}
