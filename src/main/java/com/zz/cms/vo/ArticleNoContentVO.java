package com.zz.cms.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zz.cms.enums.DeletedEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleNoContentVO {
    private Integer id;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private String artDesc;
    private String artTitle;
    private String artType;
    private DeletedEnum deleteFlag;
    private Integer artReadCount;
}
