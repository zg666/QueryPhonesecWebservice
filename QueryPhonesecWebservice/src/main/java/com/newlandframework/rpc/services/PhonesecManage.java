package com.newlandframework.rpc.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.jws.WebParam;
import javax.jws.WebService;



import com.newlandframework.rpc.services.pojo.T_SYS_PHONESEC;


@WebService  
public interface PhonesecManage {
	String queryPhonesec(@WebParam(name="fstart") String fstart);
}
