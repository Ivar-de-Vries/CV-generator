package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;

@Table(name = "LanguageSkill")
@Entity
public class LanguageSkill implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Value", nullable = false)
    private String value;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
