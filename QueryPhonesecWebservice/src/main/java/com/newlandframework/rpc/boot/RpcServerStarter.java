/**
 * Copyright (C) 2016 Newland Group Holding Limited
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.newlandframework.rpc.boot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlandframework.rpc.db.ConnectionPool;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;


/**
* 启动类，将号段表的数据全部放在map中
 */
public class RpcServerStarter {
	private static Logger logger = Logger.getLogger(RpcServerStarter.class);
	  public static volatile HashMap<String,T_SYS_PHONESEC> m=new HashMap<String,T_SYS_PHONESEC>();
    public static void start() {
    
    
    logger.info("进入RpcServerStarter的start方法");
	 T_SYS_PHONESEC bean=null;
	    
     try {
			ConnectionPool cp=ConnectionPool.getInstance();
		String sql = "select fid,fstart,fprovince_id,fcity_id,fcreate_time,freserve from T_SYS_PHONESEC where fstart='1300000' or fstart='1300012' ";
		//String sql = "select fid,fstart,fprovince_id,fcity_id,fcreate_time,freserve from T_SYS_PHONESEC";
			Connection conn = cp.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, "%" + fstart + "%");   
			ResultSet rs = ps.executeQuery();
		int i=0;
		String fid="",fprovince_id="",fcity_id="",fcreate_time="",freserve="";
			while (rs.next()) {    
				bean = new T_SYS_PHONESEC();
			fid=rs.getString(1);
			fprovince_id=rs.getString(3);
			fcity_id=rs.getString(4);
			fcreate_time=rs.getString(5);
			freserve=rs.getString(6);
				  bean.setFid(fid);
				  bean.setFstart(rs.getString(2));
				  bean.setFprovince_id(fprovince_id);    
				  
				    bean.setFcity_id(fcity_id);
				    bean.setFcreate_time(fcreate_time);
				    bean.setFreserve(freserve);
				    RpcServerStarter. m.put(rs.getString(2),bean);
				  i++;
				  logger.info(i);
				

			}
			logger.info("m.size()="+RpcServerStarter.m.size());
			cp.release(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
      //  new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-server.xml");
       
    }
}

