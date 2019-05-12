package com.hvary.mr.crawler.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Hero {
    private Long id;

    private Integer star;

    private Integer isPublic;

    private String heroName;

    private String sex;

    private String kind;

    private String tag;

    private String zhizhi;

    private String position;

}
