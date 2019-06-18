package com.overzet.springbootwebapp.author.mapper;

import com.overzet.springbootwebapp.author.entity.Entity;
import org.mapstruct.Mapping;

@org.mapstruct.Mapper
public interface Mapper {
    @Mapping(target = "id", source = "id")
    Entity authorToMap(Entity entity);

}
