package com.lgcns.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class MyDeviceServer implements Runnable {

	public int port;

	public MyDeviceServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int[] ports = {5001,5002,5003};

		for(int i=0 ; i<ports.length ; i++) {
			Thread t = new Thread(new MyDeviceServer(ports[i]));
			t.start();
		}

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		//서버 인스턴스 생성	
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(port);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();

		//Servelt 에 Routing정보를 넘기기 위해서 ServletHolder 으로 서블릿등록.
		ServletHolder myServletHolder = new ServletHolder(MyDeviceServlet.class); //서블릿클래스를 Holser 에 등록
		myServletHolder.setInitParameter("port", port+""); //파일로 읽은 문자열
		//myServletHolder.setInitParameter("serverCommandInfoStr", serverCommandInfoStr); //파일로 읽은 문자열
		servletHandler.addServletWithMapping(myServletHolder, "/"); //ServletHolder를 핸들러에 등록.

		server.setHandler(servletHandler);
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
