package com.bwie.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bwie.weixin.service.CoreService;
import com.bwie.weixin.util.MessageUtil;
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
		String encryptType = request.getParameter("encrypt_type");
		System.out.println("encryptType :" + encryptType);

		PrintWriter writer = response.getWriter();

		try {
			if (SignUtil.checkSignature(signature, timestamp, nonce)) {
				Map<String, String> map = null;
				// 如果微信服务器发来的数据包是加密,对它进行解密
				if (encryptType != null && !"".equals(encryptType) && "aes".equals(encryptType)) {
					map = MessageUtil.parseJCE(request, timestamp, nonce);
					// 返回响应的明文消息
					String msg = CoreService.processRequest(map);
					System.out.println("---->明文:" + msg);
					// 将响应的明文消息进行加密,并发送到微信服务器
					String encryptMsg = MessageUtil.getWXBizMsgCrypt().encryptMsg(msg, timestamp, nonce);
					System.out.println("-->加密:" + encryptMsg);
					writer.write(encryptMsg);
				} else {
					String responseXML = CoreService.processRequest(map);
					writer.write(responseXML);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writer.flush();
		writer.close();
	}

}
