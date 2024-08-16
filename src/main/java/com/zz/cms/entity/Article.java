package com.zz.cms.entity;

import com.zz.cms.enums.DeletedEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "t_article")
public class Article implements Serializable {

    @Serial
    private static final long serialVersionUID = -6427890654347545646L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String artContent;
    private LocalDateTime createTime;
    private String artDesc;
    private String artTitle;
    private String artType;
    private DeletedEnum deleteFlag;
    private Integer artReadCount;
}