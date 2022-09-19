package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Certificate")
@Entity
public class Certificate implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "courseName", nullable = false)
    private String courseName;

    @Column(name = "aquired", nullable = false)
    private LocalDate acquired;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employeeId", nullable = false)
    private Employee employee;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getAcquired() {
        return acquired;
    }

    public void setAcquired(LocalDate acquired) {
        this.acquired = acquired;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
