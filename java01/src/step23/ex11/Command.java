/* 역활: HttpProcessor(caller)와 요청처리 객체(callee) 사이의 호출 규칙을 정의한다. */

package step23.ex11;

import java.io.PrintStream;

public interface Command {
  
  void service(PrintStream out) throws Exception;
  
}
