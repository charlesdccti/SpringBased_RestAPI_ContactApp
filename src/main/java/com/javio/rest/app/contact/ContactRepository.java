package com.javio.rest.app.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @contactRepository.findOne(#id)?.user?.email == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #contact.user?.email ==  authentication.name")
    void delete(@Param("contact") Contact entity);
}
