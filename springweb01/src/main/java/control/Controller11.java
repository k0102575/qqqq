/* Spring MVC : Request Handler(요청을 처리하는 메서드)의 파라미터들 I */
package control;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller11/")

public class Controller11 {

  @RequestMapping("ok1")
  public void ok1() throws Exception {
    System.out.println("ok1 프론트 컨트롤러로부터 아무것도 받지 않는다.");
  }

  @RequestMapping("ok2")
  public void ok2(HttpServletRequest req) throws Exception {
    System.out.println("ok2()");
  }
  
  @RequestMapping("ok3")
  public void ok3(HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok3()");
  }
  
  @RequestMapping("ok4")
  public void ok4(HttpServletRequest req, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok4()");
  }
  
  @RequestMapping("ok5")
  public void ok5(HttpSession session, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok5()");
  }
  
//  @RequestMapping("ok6") // 오류
//  public void ok6(FileInputStream in, HttpServletResponse res) throws Exception {
//    res.setContentType("text/plain;charset=UTF-8");
//    PrintWriter out = res.getWriter();
//    out.println("ok6()");
//  }
  
  @RequestMapping("ok7")
  public void ok7(Map<String,Object> store, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok7()");
    
    store.put("name", "홍길동");
    store.put("age", 20);
  }

  @RequestMapping("ok8")
  public void ok8(Model store, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok8()");
    
    store.addAttribute("name", "홍길동");
    store.addAttribute("age", 20);
  }
  
  @RequestMapping("ok9")
  public void ok9(HttpServletRequest req, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok9()");
    
    out.printf("name: %s\n", req.getParameter("name"));
    out.printf("age: %d\n", Integer.parseInt(req.getParameter("age")));
    out.printf("working: %b\n", Boolean.parseBoolean(req.getParameter("wrokling")));
  }
  
  @RequestMapping("ok10")
  public void ok10(String name,int age, boolean working, HttpServletResponse res) throws Exception {
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("ok10()");
    
    out.printf("name: %s\n", name);
    out.printf("age: %d\n", age);
    out.printf("working: %b\n", working);
  }
}