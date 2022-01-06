package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("============ < MyDispatcher In > ============");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		System.out.println("uri: "+uri);
		System.out.println("conPath: "+conPath); // properties - Web Project Settings - context root 값 
		System.out.println("com: "+com); // 주소줄을 간결하게 표현하기 위해 conPath를 자른 것
		
		
		
		// NoticeDetailController controller1=new NoticeDetailController();
		// NoticeEditController controller2=new NoticeEditController();
		
		// 인터페이스 타입으로 통일시킴 (Controller 타입)
//		try {
//			if (com.equals("/customer/noticeDetail.do")) {
//				
//			
//			}
//			
//			controller.execute(request,response);
//		} catch (Exception e) {
//			
//		}
	}
}
