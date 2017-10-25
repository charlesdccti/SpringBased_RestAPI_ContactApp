package com.javio.rest.app.category;


import com.javio.rest.app.user.User;
import com.javio.rest.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Category.class)
public class CategoryEventHandler {

    private final UserRepository users;

    @Autowired
    public CategoryEventHandler(UserRepository users){
        this.users = users;
    }

    @HandleBeforeCreate
    public void addUserBasedOnLoggedInUser(Category category){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByEmail(username);
        category.setUser(user);

    }
}
