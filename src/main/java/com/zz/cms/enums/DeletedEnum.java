package com.zz.cms.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeletedEnum {
    DELETED(1, "已删除"),
    NOT_DELETED(0, "未删除"),
    ;

    private final Integer code;

    @JsonValue
    private final String msg;
}
