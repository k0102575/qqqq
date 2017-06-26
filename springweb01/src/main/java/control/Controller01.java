/* Spring MVC : 페이지 컨트롤러 만들기 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller01 {
  
  @RequestMapping("/control/controller01")
  public void service(HttpServletRequest req, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("Hello, World");
  }
}