package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;

@Table(name = "Education")
@Entity
public class Education implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "InstituteId", nullable = false)
    private Institute instituteId;

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

    public Institute getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Institute instituteId) {
        this.instituteId = instituteId;
    }
}
