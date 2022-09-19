package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TrainingParticipation")
@Entity
public class TrainingParticipation implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EmployeeId", referencedColumnName = "ID", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TrainingId", referencedColumnName = "ID", nullable = false)
    private Training training;

    @Column(name = "Begindate", nullable = false)
    private LocalDate beginDate;

    @Column(name = "Enddate", nullable = false)
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

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
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