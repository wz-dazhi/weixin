package com.bwie.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwie.weixin.service.CoreService;
import com.bwie.weixin.util.SignUtil;

/**
 * Servlet implementation class CoreServlet
 */
@WebServlet(name = "coreServlet", urlPatterns = { "/coreServlet" })
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		PrintWriter writer = response.getWriter();

		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			writer.println(echostr);
		}
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		PrintWriter writer = response.getWriter();

		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			String responseXML = CoreService.processRequest(request);
			writer.write(responseXML);
		}
		writer.flush();
		writer.close();
	}

}
