package com.hvary.mr.crawler;


import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import com.hvary.mr.crawler.entity.Hero;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.util.ArrayList;
import java.util.List;

@Crawler(name = "ming")
public class Ming extends BaseSeimiCrawler {
    @Override
    public String[] startUrls() {
        return new String[]{"http://wiki.joyme.com/arknights/%E5%B9%B2%E5%91%98%E6%95%B0%E6%8D%AE%E8%A1%A8"};
    }

    @Override
    public void start(Response response) {
        JXDocument document = response.document();
        List<Object> trs = document.sel("//table[@id='CardSelectTr']/tbody/tr");

        getRole(response);
    }


    private void getRole(Response response) {
        JXDocument doc = response.document();
        try {

            List<Hero> heroes = new ArrayList<>();

            List<JXNode> trs = doc.selN("//table[@id='CardSelectTr']/tbody/tr[position()>1]");

            for (JXNode tr : trs) {
                Hero hero = new Hero();

                String name = tr.sel("/td[1]//a/@title").toString();
                String pic = tr.sel("/td[1]//img/@src").toString();
                String role = tr.sel("/td[4]/text()").toString();
                String star = tr.sel("/td[5]/text()").toString();
                String feat = tr.sel("/td[18]/text()").toString();
                String tag = tr.sel("/td[19]/text()").toString();
                String sex = tr.sel("/td[6]/text()").toString();

                logger.info(hero.toString());
                heroes.add(hero);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
