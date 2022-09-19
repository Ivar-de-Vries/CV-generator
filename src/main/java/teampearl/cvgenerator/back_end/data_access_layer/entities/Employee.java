package teampearl.cvgenerator.back_end.data_access_layer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(
        name = "Employee",
        indexes = {
        @Index(
                name = "ak_emailadres",
                columnList = "EmailAddress",
                unique = true
        )}
)
@Entity
public class Employee implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Emailaddress", nullable = false)
    private String emailAddress;

    @Column(name = "Firstname", nullable = false)
    private String firstname;

    @Column(name = "Lastname", nullable = false)
    private String lastname;

    @Column(name = "Gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "Birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "Driverlicense", nullable = false)
    private Boolean driverLicense = false;

    @Column(name = "Description", nullable = false, length = 1024)
    private String description;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(Boolean driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}