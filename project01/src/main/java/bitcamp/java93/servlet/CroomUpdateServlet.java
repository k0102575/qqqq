/* 회원 관리 만들기 : 회원 등록하기 */
package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.CroomDao;
import bitcamp.java93.domain.Croom;

@WebServlet(urlPatterns="/croom/update")
public class CroomUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Croom c = new Croom();
    
    c.setNo(Integer.parseInt(req.getParameter("no")));
    c.setName(req.getParameter("name"));
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>교실관리</title>");
    
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>교실 변경</h1>");

    try {
      CroomDao croomDao = (CroomDao) this.getServletContext().getAttribute("croomDao");

      int count = croomDao.update(c);
      if (count < 1) {
        throw new Exception(c.getNo() + "번 회원을 찾지 못했습니다.");
      }
      out.println("<p>변경 성공 입니다.</p>");
      
      res.setHeader("Refresh", "1;url=list");
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/croom/error");
      rd.forward(req, res);
      
      return;
    }
    
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);

    out.println("</body>");
    out.println("</html>");


  } // service()

}
