package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap09.HelloController;

/**
 * class         : ControllerConfig
 * date          : 24-12-08
 * description   : 컨트롤러를 스프링 빈으로 등록하는 설정 클래스
 */
@Configuration
public class ControllerConfig {

    /**
     * method        : helloController
     * date          : 24-12-08
     * param         : none
     * return        : HelloController - HelloController 빈 객체
     * description   : HelloController를 스프링 컨텍스트에 빈으로 등록
     */
    @Bean
    public HelloController helloController() {
        return new HelloController();  // HelloController 빈 생성 및 반환
    }

}