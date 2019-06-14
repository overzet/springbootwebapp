package com.overzet.springbootwebapp.repository;

import com.overzet.springbootwebapp.domainmodel.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
