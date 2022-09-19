package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;

@Table(name = "Training")
@Entity
public class Training implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "InstituteId", referencedColumnName = "ID", nullable = false)
    private Institute institute;

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

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
}