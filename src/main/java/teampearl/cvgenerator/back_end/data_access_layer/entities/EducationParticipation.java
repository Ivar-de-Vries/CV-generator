package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "EducationParticipation")
@Entity
public class EducationParticipation implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EducationId", nullable = false)
    private Education education;

    @Column(name = "BeginDate", nullable = false)
    private LocalDate beginDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDate endDate;

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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
