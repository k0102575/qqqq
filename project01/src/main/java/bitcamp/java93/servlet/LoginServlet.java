package bitcamp.java93.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java93.dao.MemberDao;
import bitcamp.java93.domain.Member;

@WebServlet(urlPatterns="/auth/login")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    Cookie[] cookies = req.getCookies();
    String email = "";
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if(cookie.getName().equals("email")) {
          email = cookie.getValue();
          break;
        }
      }
    }

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인</title>");

    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);

    out.println("</head>");
    out.println("<body>");

    rd = req.getRequestDispatcher("/header");
    rd.include(req, res);

    out.println("<h1>회원 로그인</h1>");
    out.println("<form action='login' method='POST'>");
    out.printf("<p>이메일:<input type='text' name='email' value='%s'></p>\n", email);
    out.println("<p>암호:<input type='password' name='password'></p>");
    out.println("<input type='checkbox' name='saveEmail'> 이메일 저장");
    out.println("<p><button>로그인</button></p>");
    out.println("</form>");

    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);

    out.println("</body> ");
    out.println("</html>");

  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    String email = req.getParameter("email");
    String password = req.getParameter("password");

    try {

      MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");

      Member member = memberDao.selectOneByEmailPassword(email, password);

      if (member != null) {
        
        HttpSession session = req.getSession();
        
        session.setAttribute("loginMember", member);
        
        String saveEmail = req.getParameter("saveEmail");
        if (saveEmail != null) {
          Cookie cookie2 = new Cookie("email", email);
          cookie2.setMaxAge(60 * 60 * 24 * 7);
          res.addCookie(cookie2);
        } else {
          Cookie cookie2 = new Cookie("email", "");
          cookie2.setMaxAge(0);
          res.addCookie(cookie2);
        }

        res.sendRedirect("../member/list");

      } else {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>로그인</title>");

        RequestDispatcher rd = req.getRequestDispatcher("/style/core");
        rd.include(req, res);

        out.println("</head>");
        out.println("<body>");

        res.setHeader("Refresh", "2;url=login");

        out.println("<h1>로그인 오류!</h1>");

        out.println("<p>이메일 또는 암호가 맞지 않습니다.</p>");

        rd = req.getRequestDispatcher("/footer");
        rd.include(req, res);

        out.println("</body>");
        out.println("</html>");
      }

    } catch (Exception e) {
      req.setAttribute("error", e);

      RequestDispatcher rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);

      return;
    }

  } // service()

}