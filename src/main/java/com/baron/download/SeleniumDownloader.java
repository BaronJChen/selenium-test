package com.baron.download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.PlainText;

/**
 * Created by Baron.Chen on 2017/6/11.
 */
public class SeleniumDownloader implements Downloader {
    public Page download(Request request, Task task) {
        String url = request.getUrl();
        WebDriver driver = new HtmlUnitDriver();
        driver.get(url);

        String content = driver.findElement(By.xpath("/html")).getAttribute("outerHTML");
        Page page = new Page();
        page.setRawText(content);
        page.setRequest(request);
        page.setUrl(new PlainText(url));
        return page;
    }

    public void setThread(int i) {
    }
}
