package osva.springframework.simplecrud.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
    @Id
    @NotNull(message = "Registration Number Must Be Set!!")
    private Integer registrationNumber;
    @Version
    private Integer version;
    @NotBlank(message = "Name is mandatory!")
    private String name;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    private String phone;
    @Email(message = "The email provide is invalid!")
    @NotBlank(message = "Can't be blank")
    private String email;

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "registrationNumber=" + registrationNumber +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
