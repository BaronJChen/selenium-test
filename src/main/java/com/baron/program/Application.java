package com.baron.program;

import com.baron.download.SeleniumDownloader;
import com.baron.processor.PageProcessor;
import us.codecraft.webmagic.Spider;

/**
 * Created by Baron.Chen on 2017/6/11.
 */
public class Application {
    public static void main(String [] args) {
        Spider spider = Spider.create(new PageProcessor())
                .addUrl("http://sh.fang.lianjia.com/detail/taihehongqiao/");
        spider.start();
    }
}
