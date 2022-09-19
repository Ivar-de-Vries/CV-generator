package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;

@Entity
@Table(name = "Project")
public class Project implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CompanyId", nullable = false)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}