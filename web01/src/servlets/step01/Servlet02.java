/* 웹 애플리케이션 컴포넌트  - 서블릿 만들기 II - GenericServlet 추상 클래스 상속 받기 */

package servlets.step01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/servlets/step01/Servlet02")
public class Servlet02 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet02.service()");    
  } // service()
}
