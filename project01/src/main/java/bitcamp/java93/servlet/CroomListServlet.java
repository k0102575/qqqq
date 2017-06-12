/* 회원 관리 만들기 : 게시물 목록 출력하기 페이지 번호 및 사이즈 */

package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java93.dao.CroomDao;
import bitcamp.java93.domain.Croom;

@WebServlet(urlPatterns="/croom/list")
public class CroomListServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
    int pageNo = 1;
    int pageSize = 100;
    
    try {
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
    } catch (Exception e) {}
    
    try {
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
    } catch (Exception e) {}
    
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
    
    rd = req.getRequestDispatcher("/header");
    rd.include(req, res);
    
    out.println("<h1>교실 목록</h1>");
    
    
    try {
      CroomDao croomDao = (CroomDao) this.getServletContext().getAttribute("croomDao");
    
    List<Croom> list = croomDao.selectList(pageNo, pageSize);
    
    out.println("<a href='form'>새교실</a><br>");
    
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr><th>번호</th><th>이름</th></tr>");
    out.println("<tbody>");
    
    for (Croom c : list) {
      out.println("<tr>");
      out.printf("<td>%d</td>", c.getNo());
      out.printf("<td><a href='detail?no=%d'>%s</a></td>" ,c.getNo(), c.getName());
      out.println("</tr>");
      
    }
    out.println("</tbody>");
    out.println("</table>");
    
    } catch (Exception e){
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      
      return;
    }
    
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    
    out.println("</body>");
    out.println("</html>");
    
    
  } // service()
  
}
