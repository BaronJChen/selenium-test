package com.baron.pipeline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;

/**
 * Created by Baron.Chen on 2017/6/11.
 */
public class Pipeline implements us.codecraft.webmagic.pipeline.Pipeline {
    public void process(ResultItems resultItems, Task task) {
        System.out.println(resultItems);
    }
}
