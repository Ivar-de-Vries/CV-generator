package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;

@Table(name = "LanguageLevel")
@Entity
public class LanguageLevel implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EmployeeId", referencedColumnName = "ID", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "LanguageId", referencedColumnName = "ID", nullable = false)
    private Language language;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Speaking", referencedColumnName = "ID", nullable = false)
    private LanguageSkill speakingLevel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Reading", referencedColumnName = "ID", nullable = false)
    private LanguageSkill readingLevel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Writing", referencedColumnName = "ID" ,nullable = false)
    private LanguageSkill writingLevel;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language languageId) {
        this.language = languageId;
    }

    public LanguageSkill getSpeakingLevel() {
        return speakingLevel;
    }

    public void setSpeakingLevel(LanguageSkill speakingLevel) {
        this.speakingLevel = speakingLevel;
    }

    public LanguageSkill getReadingLevel() {
        return readingLevel;
    }

    public void setReadingLevel(LanguageSkill readingLevel) {
        this.readingLevel = readingLevel;
    }

    public LanguageSkill getWritingLevel() {
        return writingLevel;
    }

    public void setWritingLevel(LanguageSkill writingLevel) {
        this.writingLevel = writingLevel;
    }
}
