package com.hvary.mr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hvary.mr.crawler.entity.Hero;
import com.hvary.mr.crawler.mapper.HeroMapper;
import com.hvary.mr.crawler.util.HtmlParse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FdgdgApplicationTests {


    @Autowired
    private HtmlParse htmlParse;

    @Autowired
    private HeroMapper heroMapper;

    @Test
    public void contextLoads() {
    }


    @Test
    public void name() throws Exception {
        htmlParse.parse();
    }

    @Test
    public void name2() {
        List<Hero> heroes = heroMapper.selectList(new QueryWrapper<>());

        System.out.println(heroes.size());
        Hero hero = new Hero().setStar(6);
        List<Hero> list = heroMapper.list(hero);
        System.out.println(list.size());
    }
}
