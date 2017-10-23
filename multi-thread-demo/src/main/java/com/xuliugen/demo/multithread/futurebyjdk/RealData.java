package com.xuliugen.demo.multithread.futurebyjdk;

import java.util.concurrent.Callable;

/**
 * Created by xuliugen on 2017/10/23.
 */
public class RealData implements Callable<String> {

    private String result;

    public RealData(String result) {
        this.result = result;
    }

    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(result);
        Thread.sleep(3000);
        return sb.toString();
    }
}
