package se.lexicon.fullstack_teaser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDate regDate;

    public AppUser(String userId, String firstName, String lastName, String email, String password, LocalDate birthDate, LocalDate regDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.regDate = regDate;
    }

    public AppUser() {
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getUserId(), appUser.getUserId()) &&
                Objects.equals(getFirstName(), appUser.getFirstName()) &&
                Objects.equals(getLastName(), appUser.getLastName()) &&
                Objects.equals(getEmail(), appUser.getEmail()) &&
                Objects.equals(getBirthDate(), appUser.getBirthDate()) &&
                Objects.equals(getRegDate(), appUser.getRegDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmail(), getBirthDate(), getRegDate());
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", regDate=" + regDate +
                '}';
    }
}
