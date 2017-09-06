package com.newlandframework.rpc.query.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.jws.WebService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlandframework.rpc.db.ConnectionPool;
import com.newlandframework.rpc.query.QueryPhonesec;
import com.newlandframework.rpc.services.PhonesecManage;
import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;


public class QueryPhonsecImpl  implements QueryPhonesec{

	/*@Override
	public T_SYS_PHONESEC queryPhonesec(String fstart) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-server.xml");
		 PhonesecManage manage = (PhonesecManage) context.getBean("demoPhonesecManage");
		 
		//ConcurrentHashMap实现线程安全
	    	ConcurrentHashMap<String, T_SYS_PHONESEC> m = new ConcurrentHashMap<String, T_SYS_PHONESEC>();
	    	 T_SYS_PHONESEC bean=null;
	    	    
	         try {
	 			ConnectionPool cp=ConnectionPool.getInstance();
	 			String sql = "select fid,fstart,fprovince_id,fcity_id,fcreate_time,freserve from T_SYS_PHONESEC ";
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
	 				   m.put(rs.getString(2),bean);
	 				  i++;
	 				  System.out.println(i);
	 				

	 			}
	 			  System.out.println("m.size()="+m.size());
	 			cp.release(conn);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
		// T_SYS_PHONESEC phonesec=manage.queryPhonesec(fstart, m);
		 System.out.println(phonesec);
		   context.destroy();
		 return phonesec;
	}*/
	

}
