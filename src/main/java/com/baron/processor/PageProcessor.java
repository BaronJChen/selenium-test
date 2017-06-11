package com.baron.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Baron.Chen on 2017/6/11.
 */
public class PageProcessor implements us.codecraft.webmagic.processor.PageProcessor{

    public void process(Page page) {
        List<String> links = page.getHtml().links().all();
        List<String> targets = new ArrayList<String>();
        for (String link : links) {
            if (link.matches(".*sh\\.fang\\.lianjia\\.com/detail/(\\w){1,}/$")) {
                targets.add(link);
            } // if
        } // for

        page.addTargetRequests(targets);
        page.getResultItems().put("name", page.getHtml().xpath("/html/body/div[5]/div[4]/div[2]/div[1]/h1/text()"));
        page.getResultItems().put("price", page.getHtml().xpath("*[@class='num price']/text()"));
    }

    public Site getSite() {
        return new Site()
                .setDomain("sh.fang.lianjia.com")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
    }
}
