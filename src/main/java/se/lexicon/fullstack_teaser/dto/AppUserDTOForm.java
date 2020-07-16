package se.lexicon.fullstack_teaser.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

public class AppUserDTOForm implements Serializable {

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
    @NotBlank(message = "Required field")
    @Size(min = 4, max = 255, message = "Password need to have at least 4 letters")
    private String password;
    @NotBlank(message = "Please confirm your password")
    private String confirm;
    @NotNull(message = "Required field")
    @PastOrPresent(message = "BirthDate cannot be in the future")
    private LocalDate birthDate;

    public AppUserDTOForm(String userId, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String firstName, @NotBlank(message = "Required field") @Size(min = 2, max = 255, message = "Need to have at least 2 letters") String lastName, @NotBlank(message = "Required field") @Email(regexp = "^(\\D)+(\\w)*((\\.(\\w)+)?)+@(\\D)+(\\w)*((\\.(\\D)+(\\w)*)+)?(\\.)[a-z]{2,}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email format is invalid") String email, @NotBlank(message = "Required field") @Size(min = 4, max = 255, message = "Password need to have at least 4 letters") String password, @NotBlank(message = "Please confirm your password") String confirm, @NotNull(message = "Required field") @PastOrPresent(message = "BirthDate cannot be in the future") LocalDate birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
        this.birthDate = birthDate;
    }

    public AppUserDTOForm() {
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "AppUserDTOForm{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
