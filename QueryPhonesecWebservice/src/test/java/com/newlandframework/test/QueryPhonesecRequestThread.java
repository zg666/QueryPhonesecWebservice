package com.newlandframework.test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.newlandframework.rpc.services.AddCalculate;
import com.newlandframework.rpc.services.PhonesecManage;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;

public class QueryPhonesecRequestThread  implements Runnable {
	  private CountDownLatch signal;
	    private CountDownLatch finish;
	    private String fstart = "";
	    private PhonesecManage pm;
	  

	    public QueryPhonesecRequestThread(PhonesecManage pm, CountDownLatch signal, CountDownLatch finish, String fstart) {
	        this.signal = signal;
	        this.finish = finish;
	        this.fstart = fstart;
	        this.pm = pm;
	      
	    }

	    public void run() {
	        try {
	        	//ConcurrentHashMap<> hm=m;
	            signal.await();
                //System.out.println("fstart="+fstart);
	        
	          String phonesec = pm.queryPhonesec(fstart); 
	          
	          System.out.println("号段："+fstart+"，对应数据为："+phonesec);
	         //   System.out.println("calc add result:[" + add + "]");

	            finish.countDown();
	        } catch (InterruptedException ex) {
	            Logger.getLogger(QueryPhonesecRequestThread.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
