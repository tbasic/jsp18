package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeDetailController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		System.out.println("========== < NoticeDetailController > ==========");
		String seq=request.getParameter("c");
		String hit=request.getParameter("h");
		
		NoticeDao dao=new NoticeDao();
		Notice n=dao.getNotice(seq,hit);
		
		// List<Notice>를 request(내장객체)에 저장
		request.setAttribute("n", n);
		// notice.jsp로 보내면서 request도 함께 포워딩
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);
		
	}
}
