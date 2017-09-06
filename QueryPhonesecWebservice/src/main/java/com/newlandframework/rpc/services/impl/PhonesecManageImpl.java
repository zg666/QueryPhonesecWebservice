package com.newlandframework.rpc.services.impl;

import java.io.StringWriter;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.jws.WebService;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlandframework.rpc.boot.RpcServerStarter;
import com.newlandframework.rpc.db.ConnDB;
import com.newlandframework.rpc.db.ConnectionPool;
import com.newlandframework.rpc.services.PhonesecManage;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;



@WebService(endpointInterface = "com.newlandframework.rpc.services.PhonesecManage",serviceName="phonesecManage")  
public class PhonesecManageImpl implements  PhonesecManage{
	private static Logger logger = Logger.getLogger(PhonesecManageImpl.class);
	public   String  queryPhonesec(String fstart){
       
		 T_SYS_PHONESEC phonesec=RpcServerStarter.m.get(fstart);
		
		 JSONObject json = JSONObject.fromObject(phonesec);
		 logger.info("查询的号段信息："+json.toString());
		 return json.toString();

	}
	}


