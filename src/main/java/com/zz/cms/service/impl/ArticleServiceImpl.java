package com.zz.cms.service.impl;

import com.zz.cms.assembler.ArticleConvert;
import com.zz.cms.dto.ArticleDTO;
import com.zz.cms.entity.Article;
import com.zz.cms.repository.ArticleRepository;
import com.zz.cms.service.ArticleService;
import com.zz.cms.vo.ArticleNoContentVO;
import com.zz.cms.vo.ArticleNoReadCountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleConvert articleConvert;

    @Override
    public ArticleNoReadCountVO getByIdNoReadCount(Integer id) {
        return articleRepository.getByIdNoReadCount(id);
    }

    @Override
    public List<ArticleNoContentVO> getAllNoContent() {
        return articleRepository.getAllNoContent();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(ArticleDTO articleDTO) {
        Article entity = articleConvert.toEntity(articleDTO);
        Article result = articleRepository.save(entity);
        articleDTO.setId(result.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(ArticleDTO articleDTO) {
        Article entity = articleConvert.toEntity(articleDTO);
        articleRepository.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer incrementReadCount(Integer id) {
        return articleRepository.callIncrementReadCount(id);
    }
}
