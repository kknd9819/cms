package com.zz.cms.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zz.cms.enums.DeletedEnum;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleDTO {
    private Integer id;
    private String artContent;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String artDesc;
    private String artTitle;
    private String artType;
    private DeletedEnum deleteFlag;
    private Integer artReadCount;
}
