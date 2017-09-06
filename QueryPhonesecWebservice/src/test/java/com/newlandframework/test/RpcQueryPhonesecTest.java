package com.newlandframework.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlandframework.rpc.boot.RpcServerStarter;
import com.newlandframework.rpc.db.ConnectionPool;
import com.newlandframework.rpc.services.AddCalculate;
import com.newlandframework.rpc.services.MultiCalculate;
import com.newlandframework.rpc.services.PhonesecManage;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;

public class RpcQueryPhonesecTest {
      
    public static void queryPhonesecTask(PhonesecManage pm, int parallel,String fstart) throws InterruptedException {
        //开始计时
        StopWatch sw = new StopWatch();
        sw.start();

        CountDownLatch signal = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(parallel);

        for (int index = 0; index < parallel; index++) {
        	QueryPhonesecRequestThread client = new QueryPhonesecRequestThread(pm, signal, finish, fstart);
            new Thread(client).start();
        }

        signal.countDown();
        finish.await();
        sw.stop();

        String tip = String.format("查询数据库RPC调用总共耗时: [%s] 毫秒", sw.getTime());
        System.out.println(tip);
    }


    public static void queryTask(PhonesecManage pm, int parallel,String fstart) throws InterruptedException {
    	RpcQueryPhonesecTest.queryPhonesecTask(pm, parallel,fstart);
        TimeUnit.MILLISECONDS.sleep(30);
    }

   

    public static void main(String[] args) throws Exception {
        //并发数量
        int parallel = 10000;  
        String  fstart="1300000";
    	List<T_SYS_PHONESEC> list = new ArrayList<T_SYS_PHONESEC>();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-client.xml");
     
        for (int i = 0; i < 1; i++) {
        	queryTask((PhonesecManage) context.getBean("phonesecManage"), parallel,fstart);
           
            System.out.printf("[author zhengguang] Netty RPC Server 消息协议序列化第[%d]轮并发验证结束!\n\n", i);
        }

        context.destroy();
    }
}
