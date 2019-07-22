package com.overzet.springbootwebapp.author.mapper;

import com.overzet.springbootwebapp.author.entity.AuthorEntity;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface Mapper {
    @Mapping(target = "id", source = "id")
    AuthorEntity authorToMap(AuthorEntity authorEntity);

}
