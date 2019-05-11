package com.hvary.mr.crawler;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.util.List;


@Crawler(name = "mo")
public class Mo extends BaseSeimiCrawler {
    @Override
    public String[] startUrls() {
        return new String[]{"https://graueneko.github.io/akhrchars.html"};

    }

    @Override
    public void start(Response response) {

        getHeros(response);

    }


    private void getHeros(Response response) {
        JXDocument document = response.document();
        List<JXNode> trs = document.selN("//table[@id='table-chars']/tbody/tr[position()>1]");
        System.out.println(trs);

        for (JXNode tr : trs) {
            String starColor = tr.sel("@class").toString();
            String name = tr.sel("/td[1]/text()").toString();
            String kind = tr.sel("/td[2]/text()").toString();
            String ispublic = tr.sel("/td[4]/text()").toString();
            logger.info(starColor + name + kind + ispublic);

        }

    }
}
