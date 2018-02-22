package org.osgi.enroute.opcua.provider;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.enroute.manager.api.Manager;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

/**
 * 
 */
@Component(name = "org.osgi.enroute.opcua",
	service = Servlet.class,
	property = HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/opcua",
	immediate = true)
public class OpcuaImpl extends HttpServlet{

	@Reference
	Manager manager;
	
	@Activate
	void activate(BundleContext context) {
		System.out.println("OPC-UA module activated");
		manager.register("Opcua");
	}

	public void doGet(HttpServletRequest rq, HttpServletResponse rsp) throws IOException, ServletException {
		System.out.println("Inside doGet");
		rsp.getOutputStream().print("OPC-UA servlet");
	}
}
