package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * class         : MvcConfig
 * date          : 24-12-08
 * description   : 스프링 MVC 설정을 위한 구성 클래스
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    /**
     * method        : configureDefaultServletHandling
     * date          : 24-12-08
     * param         : DefaultServletHandlerConfigurer configurer - 기본 서블릿 처리기 설정 객체
     * return        : void
     * description   :  configurer.enable(); =  기본 서블릿 처리를 활성화한다.
     *               :  클라이언드가 정적 리소스를 요청하면 /images/logo.png , /styles/main.css 이런 요청은 스프링 MVC 디스패처 서블릿이 처리하지 않고
     *               기본 서블릿에 전달 됨. 동적 요청은 스프링의 컨트롤러에서 처리함.
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // 기본 서블릿 처리를 활성화한다
    }

    /**
     * method        : configureViewResolvers
     * date          : 24-12-08
     * param         : ViewResolverRegistry registry - 뷰 리졸버 설정 객체
     * return        : void
     * description   : JSP 파일을 뷰로 사용하는 뷰 리졸버를 설정
     *                  리졸버는 컨트롤러가 반환한 논리적 뷰 이름(예: "home")을 실제 뷰 파일(예: /WEB-INF/view/home.jsp)로 변환하여
     *                  클라이언트에 응답을 제공하는 역할을 한다.  (최하단에 주석 처리한 컨트롤러 메서드 예시 참고 )
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");  //- 뷰 파일 경로: /WEB-INF/view/  , 파일 확장자: .jsp
    }

}

/*
컨트롤러 메소드 예시
@RequestMapping("/welcome")
public String welcome() {
        return "welcome"; // 논리적 뷰 이름
        }
        */