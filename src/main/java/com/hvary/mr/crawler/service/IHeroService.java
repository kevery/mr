package com.hvary.mr.crawler.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hvary.mr.crawler.entity.Hero;

import java.util.List;

public interface IHeroService extends IService<Hero> {


    List<Hero> getHeroByTag(String... tags);
}
