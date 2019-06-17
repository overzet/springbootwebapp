package com.overzet.springbootwebapp.authorRepository;

import com.overzet.springbootwebapp.authorEntity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
/* TODO: 2019-06-17

(nameOfClass)Service,
(nameOfClass)ServiceImpl,


 */