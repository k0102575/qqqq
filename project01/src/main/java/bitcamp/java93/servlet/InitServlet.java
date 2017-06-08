package bitcamp.java93.servlet;
/* 웹 애플리케이션 공통 자원을 준비하는 서블릿 */

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import bitcamp.java93.dao.CroomDao;
import bitcamp.java93.dao.LectDao;
import bitcamp.java93.dao.ManagerDao;
import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.util.DBConnectionPool;

@WebServlet(urlPatterns="/InitServlet", loadOnStartup=1)
public class InitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  @Override
  public void init() throws ServletException {
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
    DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
    
    MemberDao memberDao = new MemberDao(conPool);
    LectDao lectDao = new LectDao(conPool);
    ManagerDao managerDao = new ManagerDao(conPool);
    CroomDao croomDao = new CroomDao(conPool);
    
    
    ServletContext sc = this.getServletContext();
    
    sc.setAttribute("memberDao", memberDao);
    sc.setAttribute("lectDao", lectDao);
    sc.setAttribute("croomDao", croomDao);
    sc.setAttribute("managerDao", managerDao);
    
    
    
    } catch (Exception e) {
      e.printStackTrace();
    } 
    
  } // init()
  
}
