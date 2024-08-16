package com.zz.cms.assembler;

import com.zz.cms.dto.ArticleDTO;
import com.zz.cms.entity.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleConvert {

    ArticleDTO toDto(Article entity);
    List<ArticleDTO> toDto(List<Article> entityList);
    Article toEntity(ArticleDTO dto);
}
