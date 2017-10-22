package com.xuliugen.demo.multithread.future;

/**
 * 真实数据，其构造速度较慢
 * Created by xuliugen on 2017/10/22.
 */
public class RealData implements Data {

    private String result;

    public RealData(String param) {
        StringBuffer sb = new StringBuffer();
        sb.append(param);
        try {
            //模拟构造真实数据的耗时操作
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
