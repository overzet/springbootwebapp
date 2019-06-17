package com.overzet.springbootwebapp.authorMapper;

import com.overzet.springbootwebapp.authorEntity.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AuthorMapper {
    @Mapping(target = "id", source = "id")
    AuthorEntity authorToMap(AuthorEntity authorEntity);

}
