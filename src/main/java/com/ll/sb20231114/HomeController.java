package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤로인것을 스프링에게 명시
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    String showMain(){
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody
    //이 함수의 리턴 값을 그대로 브라우저에 출력하라는 의미
    String showAbout(){
        return "개발자 커뮤니티";
    }



}
