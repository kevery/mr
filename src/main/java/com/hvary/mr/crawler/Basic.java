package com.hvary.mr.crawler;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Request;
import cn.wanghaomiao.seimi.struct.Response;
import org.seimicrawler.xpath.JXDocument;

import java.util.List;

@Crawler(name = "basic")
public class Basic extends BaseSeimiCrawler {
    @Override
    public String[] startUrls() {
        return new String[]{"http://www.cnblogs.com/", "http://www.cnblogs.com/"};
    }

    @Override
    public void start(Response response) {
        JXDocument document = response.document();

        List<Object> urls = document.sel("//a[@class='titlelnk']/@href");
        logger.info("{}", urls.size());
        for (Object url : urls) {
            push(Request.build(url.toString(), Basic::getTitle));
        }

    }


    private void getTitle(Response response) {
        JXDocument doc = response.document();
        try {
            logger.info("url:{} {}", response.getUrl(), doc.sel("//h1[@class='postTitle']/a/text()|//a[@id='cb_post_title_url']/text()"));
            //do something
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
