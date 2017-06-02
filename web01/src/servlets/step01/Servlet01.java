/* 웹 애플리케이션 컴포넌트  - 서블릿 만들기 I */

package servlets.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/servlets/step01/Servlet01")
public class Servlet01 implements Servlet {
  
  public Servlet01() {
    System.out.println("HelloServlet()");
  } // 생성자

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet01.init()");
  } // init()

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet01.getServletConfig()");    return null;
  } // getServletConfig

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet01.service()");    
  } // service()

  @Override
  public String getServletInfo() {
    System.out.println("Servlet01.getServletInfo()");    return null;
  } // getServletInfo()

  @Override
  public void destroy() {
    System.out.println("Servlet01.destroy()");    
  } // destroy()
}