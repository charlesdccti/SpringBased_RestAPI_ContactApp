package com.javio.rest.app.contact;

import com.javio.rest.app.user.User;
import com.javio.rest.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Contact.class)
public class ContactEventHandler {

    private final UserRepository users;

    @Autowired
    public ContactEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addContactBasedOnLoggedInUser(Contact contact){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByEmail(email);
        contact.setUser(user);
    }
}
