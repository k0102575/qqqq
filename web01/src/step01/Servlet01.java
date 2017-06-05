/* 웹 애플리케이션 컴포넌트  - 서블릿 만들기 I 
 * 
 * 기본 서블릿 인터페이스를 implements 하는 클래스
 * 
 * */

package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step01/Servlet01")
public class Servlet01 implements Servlet {
  
  public Servlet01() {
    System.out.println("/step01/HelloServlet01()");
  } // 생성자

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("/step01/Servlet01.init()");
  } // init()

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("/step01/Servlet01.getServletConfig()");    return null;
  } // getServletConfig

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("/step01/Servlet01.service()");    
  } // service()

  @Override
  public String getServletInfo() {
    System.out.println("/step01/Servlet01.getServletInfo()");    return null;
  } // getServletInfo()

  @Override
  public void destroy() {
    System.out.println("/step01/Servlet01.destroy()");    
  } // destroy()
}
