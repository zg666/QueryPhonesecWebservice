package com.newlandframework.test.impl;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
public class webServiceTest {


	public static void main(String[] args) {
	
		
		try {
			  String endpoint = "http://192.168.211.1:8080/QueryPhonesecWebservice/cxf/queryPhonesec";
			  //直接引用远程的wsdl文件
			 // 直接引用远程的wsdl文件
			  Service service = new Service();
			  Call call = (Call) service.createCall();
			   QName qName = new QName("http://services.rpc.newlandframework.com/", "queryPhonesec"); 
			  call.setTargetEndpointAddress(endpoint);
			  call.setOperationName(qName);//WSDL里面描述的接口名称
			  call.addParameter("fstart", org.apache.axis.encoding.XMLType.XSD_DATE,
			  javax.xml.rpc.ParameterMode.IN);//接口的参数
			  call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型 

			  String temp = "1300000";
			  String result = (String)call.invoke(new Object[]{temp});
			  //给方法传递参数，并且调用方法
			  System.out.println("result is "+result);
			  }
			  catch (Exception e) {
			  System.err.println(e.toString());
			  }
	}
	
	
}

