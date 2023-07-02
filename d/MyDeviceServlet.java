package com.lgcns.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

public class MyDeviceServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String reqURI = req.getRequestURI(); //��ûURI
		String port = getInitParameter("port");
		System.out.println(port);
		//DeviceInfo deviceInfo = MyUtils.convertDeviceInfo(getInitParameter("deviceInfoStr"));
		//ServerCommandInfo serverCommandInfo = MyUtils.convertServerCommandInfo(getInitParameter("serverCommandInfoStr"));
		
		String bodyJsonStr = MyUtils.getHttpBodyInString(req);
		
		if (reqURI.startsWith("/fromNode")) {
			
			//������ ��û���� : command, targetDevice, parameter
			RequestInfo nodeRequestInfo = MyUtils.convertRequestInfo(bodyJsonStr);
			
			// �������伳��
			DeviceResponse DeviceResult = new DeviceResponse(nodeRequestInfo.getParam() + "_"+ port);
			String deviceResponseStr = MyUtils.convertDeviceResponse(DeviceResult);
			
			res.setStatus(200);
			res.getWriter().write(deviceResponseStr);
		}
		
	}
}
