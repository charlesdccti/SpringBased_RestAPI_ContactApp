package com.javio.rest.app.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @categoryRepository.findOne(#id)?.user?.email == authentication.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #category.user?.email ==  authentication.name")
    void delete(@Param("category") Category entity);
}
