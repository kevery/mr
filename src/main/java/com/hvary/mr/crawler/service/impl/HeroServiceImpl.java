package com.hvary.mr.crawler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hvary.mr.crawler.entity.Hero;
import com.hvary.mr.crawler.mapper.HeroMapper;
import com.hvary.mr.crawler.service.IHeroService;
import com.hvary.mr.crawler.util.TagBelongUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 英雄服务类
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements IHeroService {
    @Override
    public List<Hero> getHeroByTag(String... tags) {
        if (tags.length > 3 || tags.length < 1) {
            throw new IllegalArgumentException("输入的tag个数最低一项最多三项");
        }

        for (String tag : tags) {
            if (TagBelongUtil.isBelongPostion(tag)) {

            }

            if (TagBelongUtil.isBelongsexList(tag)) {


            }
        }
        return null;
    }
}
