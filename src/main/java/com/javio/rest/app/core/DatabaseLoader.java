package com.javio.rest.app.core;

import com.javio.rest.app.category.Category;
import com.javio.rest.app.category.CategoryRepository;
import com.javio.rest.app.contact.Contact;
import com.javio.rest.app.user.User;
import com.javio.rest.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CategoryRepository categories;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(CategoryRepository categories, UserRepository users) {
        this.categories = categories;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Category category = new Category("famille", "liste famille");
        category.addContact(new Contact("Toto", "Otto", "0102030405", "ototo@email.com" ));

        categories.save(category);

        List<User> students = Arrays.asList(
                new User("jacobproffer@email.com", "Proffer", new String[]{"ROLE_USER"}),
                new User("mlnorman@email.com", "password", new String[]{"ROLE_USER"}),
                new User("k_freemansmith@email.com", "password", new String[]{"ROLE_USER"}),
                new User("seth_lk@email.com", "Kroger", new String[]{"ROLE_USER"}),
                new User("mrstreetgrid@email.com", "Java", new String[]{"ROLE_USER"})
        );

        users.save(new User("jack@email.com", "password", new String[] {"ROLE_USER", "ROLE_ADMIN"}));

        users.save(students);
    }
}