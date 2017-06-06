package lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/lect/Servlet04")
public class Servlet04 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>강의관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 조회</h1>");

    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);

      LectDao lectDao = new LectDao(conPool);
      CroomDao croomDao = new CroomDao(conPool);
      ManagerDao managerDao = new ManagerDao(conPool);


      int no = Integer.parseInt(req.getParameter("no"));

      Lect lect = lectDao.selectOne(no);
      List<Croom> croom = croomDao.selectList();
      List<Manager> manager = managerDao.selectList();
      
      
      if (lect == null) {
        throw new Exception(no + "번 회원을 찾지 못했습니다.");
      }

      out.printf("<form action='Servlet05' method='POST'>\n");
      out.printf("번호:<input type='text' name='no' value='%d' readonly><br>\n", lect.getNo());
      out.printf("제목:<input type='text' name='titl' value='%s'><br>\n", lect.getTitl());
      out.printf("설명:<input type='text' name='dscp' value='%s'><br>\n", lect.getDscp());
      out.printf("시작일:<input type='date' name='sdt' value='%s'><br>\n", lect.getSdt());
      out.printf("종료일:<input type='date' name='edt' value='%s'><br>\n", lect.getEdt());
      out.printf("총수강인원:<input type='text' name='qty' value='%d'><br>\n", lect.getQty());
      out.printf("가격:<input type='text' name='pric' value='%d'><br>\n", lect.getPric());
      out.printf("총시간:<input type='text' name='thrs' value='%d'><br>\n", lect.getThrs());
      out.println("<select name='crmno'><br>");
      out.println("<option value='0'>강의실을 선택하세요!</option><br>\n");
      for (Croom c : croom) {
        out.printf("<option value='%d'>%s</option>", c.getNo(), c.getName());
      }
      out.println("</select><br>");
      
      out.println("<select name='mrno'><br>");
      out.println("<option value='0'>매니저를 선택하세요!</option><br>\n");
      for (Manager m : manager) {
        out.printf("<option value='%d'>%s</option>", m.getNo(), m.getName());
      }
      out.println("</select><br>");
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");

    } catch (Exception e) {
      out.print("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='Servlet02'>목록</a>");
    }
    
    out.println("<script>");
    out.println("function doDelete() {");
    out.printf("  location.href = 'Servlet06?no=%s'\n", req.getParameter("no"));
    out.println("}");
    out.println("</script>");
    
    out.println("<script>");
    out.println("function doList() {");
    out.println("location.href = 'Servlet02'");
    out.println("}");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");

    System.out.printf("RemoteAddress: %s\n", req.getRemoteAddr());

  } // service()

}
