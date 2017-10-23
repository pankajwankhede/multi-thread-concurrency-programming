package com.xuliugen.demo.multithread.future;

/**
 * 返回Data对象，立即返回FutureData，并开启ClientThread线程装配RealData
 * Created by xuliugen on 2017/10/22.
 */
public class Client {

    public Data request(String param) {
        //立即返回FutureData
        FutureData futureData = new FutureData();
        //开启ClientThread线程装配RealData
        new Thread(() -> {
            {
                //装配RealData
                RealData realData = new RealData(param);
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }
}
