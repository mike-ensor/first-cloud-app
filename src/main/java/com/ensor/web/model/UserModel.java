package com.ensor.web.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {

//    @NotEmpty(message = "{field.required}")
    @Email(message = "{field.email}")
    @Size(min = 1, max = 40, message = "{field.size}")
    private String email;
    @Size(min = 1, max = 40, message = "{field.size}")
    private String firstName;
    @Size(min = 1, max = 40, message = "{field.size}")
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
