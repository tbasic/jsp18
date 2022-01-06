package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("========== < NoticeController > ==========");
	
		
		NoticeDao dao=new NoticeDao();
		List<Notice> list=dao.noticeSelAll();
		
		// List<Notice>를 request(내장객체)에 저장
		request.setAttribute("list", list);
		// notice.jsp로 보내면서 request도 함께 포워딩
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
	}
}
