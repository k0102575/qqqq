package bitcamp.java93.servlet;
/* 회원 관리 만들기 : 회원 등록하기 */



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/member/add")
public class MemberAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Member m = new Member();

    m.setName(req.getParameter("name"));
    m.setTel(req.getParameter("tel"));
    m.setEmail(req.getParameter("email"));
    m.setPassword(req.getParameter("password"));



    try {
      //      ServletContext sc = this.getServletContext();
      //      MemberDao memberDao = (MemberDao) sc.getAttribute("memberDao");
      MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
      
      memberDao.insert(m);
      
      res.sendRedirect("list");
    } catch (Exception e) {
      req.setAttribute("error", e);
      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);

      return;
    }
    
  } // service()

}