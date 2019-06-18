package com.overzet.springbootwebapp.author.repository;

import com.overzet.springbootwebapp.author.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Repository extends JpaRepository<Entity, Long> {
}
/* TODO: 2019-06-17

(nameOfClass)Service,
(nameOfClass)ServiceImpl,


 */