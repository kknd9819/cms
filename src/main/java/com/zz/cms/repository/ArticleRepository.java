package com.zz.cms.repository;

import com.zz.cms.entity.Article;
import com.zz.cms.vo.ArticleNoContentVO;
import com.zz.cms.vo.ArticleNoReadCountVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select new com.zz.cms.vo.ArticleNoContentVO(a.id,a.createTime," +
            "a.artDesc,a.artTitle,a.artType,a.deleteFlag,a.artReadCount) from Article a " +
            "where a.id = ?1")
    ArticleNoContentVO getByIdNoContent(Integer id);

    @Query("select new com.zz.cms.vo.ArticleNoContentVO(a.id,a.createTime," +
            "a.artDesc,a.artTitle,a.artType,a.deleteFlag,a.artReadCount) from Article a order by a.id desc")
    List<ArticleNoContentVO> getAllNoContent();

    @Query("select artReadCount from Article where id = ?1")
    Integer getReadCount(Integer id);

    @Query("select new com.zz.cms.vo.ArticleNoReadCountVO(a.id,a.artContent,a.createTime," +
            "a.artDesc,a.artTitle,a.artType,a.deleteFlag) from Article a")
    ArticleNoReadCountVO getByIdNoReadCount(Integer id);

    @Modifying
    @Transactional
    @Query("update Article set artReadCount = artReadCount + 1 where id = ?1")
    void addReadCount(Integer id);

    @Modifying
    @Transactional
    @Query("update Article set artTitle=:artTitle,artType=:artType,artContent=:artContent,artDesc=:artDesc,deleteFlag=:deleteFlag")
    void updateByIdNoReadCount(@Param("artTitle") String artTitle,
                              @Param("artType") String artType,
                              @Param("artContent") String artContent,
                              @Param("artDesc") String artDesc,
                              @Param("deleteFlag") Integer deleteFlag);

    @Transactional
    @Query(value = "call incre_read_count(?1)", nativeQuery = true)
    Integer callIncrementReadCount(Integer id);
}
