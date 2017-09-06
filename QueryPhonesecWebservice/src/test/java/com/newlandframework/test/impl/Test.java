package com.newlandframework.test.impl;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlandframework.rpc.boot.RpcServerStarter;
import com.newlandframework.rpc.query.QueryPhonesec;
import com.newlandframework.rpc.services.PersonManage;
import com.newlandframework.rpc.services.PhonesecManage;
import com.newlandframework.rpc.services.pojo.Person;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;



public class Test {
	private static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {  
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-client.xml");  

    	PhonesecManage manage = (PhonesecManage) ctx.getBean("queryPhonesec");


        String phonesec = manage.queryPhonesec("1300000");



        logger.info("²âÊÔµÄºÅ¶Î£º" + phonesec);
        ctx.destroy();
    
    }  
}
