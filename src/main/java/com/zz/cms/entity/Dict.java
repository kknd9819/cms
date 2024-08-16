package com.zz.cms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "t_dict")
public class Dict implements Serializable {

    @Serial
    private static final long serialVersionUID = -3724345921119743683L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String dictCode;
    private String dictValue;
    private String dictDesc;
    private LocalDateTime createTime;
}
