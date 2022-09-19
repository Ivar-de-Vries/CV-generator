package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ProjectParticipation")
public class ProjectParticipation implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ProjectId", nullable = false)
    private Project project;

    @Column(name = "Description", nullable = false, length = 1024)
    private String description;

    @Column(name = "Begindate", nullable = false)
    private LocalDate beginDate;

    @Column(name = "Enddate", nullable = false)
    private LocalDate endDate;

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate enddate) {
        this.endDate = enddate;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate begindate) {
        this.beginDate = begindate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project projectId) {
        this.project = projectId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employeeId) {
        this.employee = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}