/* 회원 관리 만들기 : 회원 등록하기 */
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step03/Servlet04")
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
    out.println("<title>회원관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 조회</h1>");

    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";

    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);

      MemberDao memberDao = new MemberDao(conPool);

      int no = Integer.parseInt(req.getParameter("no"));

      Member member = memberDao.selectOne(no);
      if (member == null) {
        throw new Exception(no + "번 회원을 찾지 못했습니다.");
      }


      out.printf("<form action='Servlet05' method='POST'>\n");
      out.printf("번호:<input type='text' name='no' value='%d' readonly><br>\n", member.getNo());
      out.printf("이름:<input type='text' name='name' value='%s'><br>\n", member.getName());
      out.printf("전화:<input type='text' name='tel' value='%s'><br>\n", member.getTel());
      out.printf("이메일:<input type='text' name='email' value='%s'><br>\n", member.getEmail());
      out.println("암호:<input type='password' name='password'><br>\n");
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");

    } catch (Exception e) {
      out.print("오류 발생!");
      // pre 태그를 주면은 엔터를 그래도 살린다.
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='Servlet02'>목록</a>");
    }
    
    // 브라우저에게 실행할 코드를 넘겨준다.
    // 자바스크립트는 브라우저에서 하는것이다.
    // 서버에서 하는것이 아니다.
    // 서블릿은 서버에서 브라우저로 던져주는것이다.
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
