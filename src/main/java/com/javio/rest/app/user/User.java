package com.javio.rest.app.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javio.rest.app.category.Category;
import com.javio.rest.app.core.BaseEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends BaseEntity {

    public static  final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(10);

    @Email
    @NotEmpty(message = "Please enter your email address.")
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String[] roles;

    protected User(){
        super();
    }

    public User(String email, String password, String[] roles) {
        this();
        this.email = email;
        setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password){
        this.password = PASSWORD_ENCODER.encode(password);
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;


    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        category.setUser(this);
        categories.add(category);
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

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
