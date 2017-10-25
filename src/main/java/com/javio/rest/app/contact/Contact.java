package com.javio.rest.app.contact;

import com.javio.rest.app.category.Category;
import com.javio.rest.app.core.BaseEntity;
import com.javio.rest.app.user.User;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Contact  extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;

    @NumberFormat
    @NotEmpty(message = "Please enter your phone number.")
    private String numTel;

    @Email
    @NotEmpty(message = "Please enter your email adress.")
    private String email;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    protected Contact(){
        super();
    }

    public Contact(String firstName, String lastName, String numTel, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numTel = numTel;
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
