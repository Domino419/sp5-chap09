package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * class         : HelloController
 * date          : 24-12-08
 * description   : "/hello" 요청을 처리하는 컨트롤러
 */

@Controller
public class HelloController {

    /**
     * method        : hello
     * date          : 24-12-08
     * param         : Model model - 뷰로 데이터를 전달하기 위한 객체
     *                 String name - 클라이언트에서 전달된 name 파라미터 (필수 아님)
     * return        : String - 뷰 이름 (hello.jsp를 렌더링)
     * description   : "/hello" 요청을 처리하여 인사 메시지를 생성하고, 뷰에 전달
     * Test url : http://localhost:8080/sp5_chap09_war_exploded/hello?name=PKN
     */
    @GetMapping("/hello")
    public String hello(Model model,
                        @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("greeting", "안녕하세요, " + name);   // "greeting" 속성에 인사 메시지를 추가 (name이 null이면 "null" 포함)
        return "hello";   // hello.jsp 뷰 이름 반환
    }
}