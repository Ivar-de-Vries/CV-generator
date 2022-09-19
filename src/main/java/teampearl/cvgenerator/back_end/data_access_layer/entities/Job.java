package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Job implements IEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CompanyId", nullable = false)
    private Company company;

    @Column(name = "\"Function\"", nullable = false)
    private String function;

    @Column(name = "Begindate", nullable = false)
    private LocalDate beginDate;

    @Column(name = "Enddate")
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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company companyId) {
        this.company = companyId;
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