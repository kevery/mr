package com.hvary.mr.crawler.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hvary.mr.crawler.entity.Hero;

import java.util.List;

public interface HeroMapper extends BaseMapper<Hero> {

    List<Hero> list(Hero hero);
}
