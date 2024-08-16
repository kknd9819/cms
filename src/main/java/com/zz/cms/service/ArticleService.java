package com.zz.cms.service;

import com.zz.cms.dto.ArticleDTO;
import com.zz.cms.vo.ArticleNoContentVO;
import com.zz.cms.vo.ArticleNoReadCountVO;

import java.util.List;

public interface ArticleService {
    ArticleNoReadCountVO getByIdNoReadCount(Integer id);
    List<ArticleNoContentVO> getAllNoContent();
    void insert(ArticleDTO articleDTO);
    void updateById(ArticleDTO articleDTO);
    Integer incrementReadCount(Integer id);
}
