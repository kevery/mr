package com.hvary.mr.crawler.util;

import com.hvary.mr.crawler.entity.Hero;
import com.hvary.mr.crawler.service.impl.HeroServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

@Component
public class HtmlParse {


    @Autowired
    private HeroServiceImpl heroServiceImpl;

    public void parse() throws Exception {

        Document parse = Jsoup.parse(new File("E:\\dict\\page.html"), "UTF-8");
        TagNode clean = new HtmlCleaner().clean(parse.html());
        Object[] objects = clean.evaluateXPath("//tbody[@id='tbody-chars']/tr");

        for (Object object : objects) {
            Hero hero = new Hero();

            TagNode tagNode = (TagNode) object;

            String star = Arrays.toString(tagNode.evaluateXPath("/@class")).replace("[", "").replace("]", "");
            String name = Arrays.toString(tagNode.evaluateXPath("/td[1]/text()")).replace("[", "").replace("]", "");
            String kind = Arrays.toString(tagNode.evaluateXPath("/td[2]/text()")).replace("[", "").replace("]", "");
            String tags = Arrays.toString(tagNode.evaluateXPath("/td[3]/text()")).replace("[", "").replace("]", "");
            String ispublic = Arrays.toString(tagNode.evaluateXPath("/td[4]/text()")).replace("[", "").replace("]", "");

            if (!StringUtils.contains(tags, "三测暂不实装")) {
                //加入英雄池

                //等级判断
                if (StringUtils.contains(star, "table-danger")) {
                    star = "6";
                } else if (StringUtils.contains(star, "table-warning")) {
                    star = "5";
                } else if (StringUtils.contains(star, "table-info")) {
                    star = "4";
                } else if (StringUtils.contains(star, "table-success")) {
                    star = "3";
                } else if (StringUtils.contains(star, "table-light")) {
                    star = "2";
                } else if (StringUtils.contains(star, "table-active")) {
                    star = "1";
                }

                //判断性别
                int positionIndex = StringUtils.indexOf(tags, "位");
                int sexIndex = StringUtils.indexOf(tags, "性干员");
                String position = StringUtils.substring(tags, positionIndex - 2, positionIndex+1);
                String sex = StringUtils.substring(tags, sexIndex - 1, sexIndex);


                String zhizhi = "";
                if (tags.contains("高级资深干员")) {
                    zhizhi = "高级资深干员";
                } else if (tags.contains("新手")) {
                    zhizhi = "新手";
                } else if (tags.contains("资深干员")) {
                    zhizhi = "资深干员";
                }

                hero.setStar(Integer.valueOf(star));
                hero.setIsPublic(ispublic.equals("是") ? 1 : 0);
                hero.setKind(kind);
                hero.setTag(tags.replace(" ","").replace("，",","));
                hero.setHeroName(name);
                hero.setZhizhi(zhizhi);
                hero.setSex(sex + "性干员");
                hero.setPosition(position);

                heroServiceImpl.save(hero);
            }

        }


    }

}
