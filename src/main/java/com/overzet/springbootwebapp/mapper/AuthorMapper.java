package com.overzet.springbootwebapp.mapper;

import com.overzet.springbootwebapp.domainmodel.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {
    @Mapping(target = "id", source = "id")
    Author authorToMap(Author author);

}
