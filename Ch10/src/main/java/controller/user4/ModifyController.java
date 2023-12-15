package controller.user4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.User4DTO;
import dto.User5DTO;
import service.User4Service;

@WebServlet("/user4/modify.do")
public class ModifyController extends HttpServlet{

	private static final long serialVersionUID = 3391546598831502670L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private User4Service service = new User4Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		User4DTO user = service.selectUser4(seq);
		
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/user4/modify.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		User4DTO dto = new User4DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		service.updateUser4(dto);
		
		resp.sendRedirect("/Ch10/user4/list.do");
	}
}
