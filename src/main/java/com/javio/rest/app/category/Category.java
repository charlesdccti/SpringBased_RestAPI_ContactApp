package com.javio.rest.app.category;

import com.javio.rest.app.contact.Contact;
import com.javio.rest.app.core.BaseEntity;
import com.javio.rest.app.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 140)
    private String name;

    @NotNull
    @Size(min = 3, max = 140)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @ManyToOne
    private User user;

    protected Category() {
        super();
        contacts = new ArrayList<>();
    }

    public Category(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contact.setCategory(this);
        contacts.add(contact);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}