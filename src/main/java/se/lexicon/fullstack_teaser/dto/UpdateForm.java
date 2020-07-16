package se.lexicon.fullstack_teaser.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class UpdateForm implements Serializable {

    @NotBlank
    private String userId;

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String firstName;

    @NotBlank(message = "Required field")
    @Size(min = 2, max = 255, message = "Need to have at least 2 letters")
    private String lastName;

    @NotBlank(message = "Required field")
    @Email(regexp = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email format is invalid")
    private String email;

    @NotNull(message = "Required field")
    @PastOrPresent(message = "BirthDate cannot be in the future")
    private LocalDate birthDate;

    public UpdateForm() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UpdateForm{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
