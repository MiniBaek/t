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
		//���� �ν��Ͻ� ����	
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(port);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();

		//Servelt �� Routing������ �ѱ�� ���ؼ� ServletHolder ���� �������.
		ServletHolder myServletHolder = new ServletHolder(MyDeviceServlet.class); //����Ŭ������ Holser �� ���
		myServletHolder.setInitParameter("port", port+""); //���Ϸ� ���� ���ڿ�
		//myServletHolder.setInitParameter("serverCommandInfoStr", serverCommandInfoStr); //���Ϸ� ���� ���ڿ�
		servletHandler.addServletWithMapping(myServletHolder, "/"); //ServletHolder�� �ڵ鷯�� ���.

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
