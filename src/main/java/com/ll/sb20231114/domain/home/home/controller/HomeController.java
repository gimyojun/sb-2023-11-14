package com.ll.sb20231114.domain.home.home.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller //컨트롤로인것을 스프링에게 명시
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    String showMain(){
        return "안녕하세요";
    }

    @GetMapping("/calc1")
    @ResponseBody
    //이 함수의 리턴 값을 그대로 브라우저에 출력하라는 의미
    String showCalc1(int a, int b){
        return "계산결과 : %d".formatted(a+b);
    }
    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b){
        return "a : " + a + " b : " + b;
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ){
        return "계산결과 : %d".formatted(a+b);
    }
    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") double b
    ){
        return "계산결과 : %f".formatted(a+b);
    }
    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "+") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }
    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
         int a, int b
    ){
        return a + b;
    }
    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ){
        return a > b;
    }
    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
        String name, int age
    ){
        return new Person(name, age);
    }
    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ){
        return new Person2(name, age);
    }
    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );

        return personMap;
    }
    @GetMapping("/calc11")
    @ResponseBody
    List<Integer> showCalc11(){

        //new Person(){이거는 이해 됨 };
        //List<Integer> nums = new ArrayList<여기는 명시적으로 안써줘도 댐>(){이부분이 익명 클래서}
        //이름이 없어서 생성자도 이름이 없다
        List<Integer> nums = new ArrayList<>(){{
            add(10);
            //익명 클래스로 this.add 가 생략 된거임
            add(100);
            add(-862);

        }};
        return nums;
    }
    @GetMapping("/calc12")
    @ResponseBody
    int[] showCalc12() {
        int[] nums = new int[]{10, -510, 10010};

        return nums;
    }

    @GetMapping("/calc13")
    @ResponseBody
    List<Person2> showCalc13(
            String name, int age
    ) {
        List<Person2> persons = new ArrayList<>() {{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};

        return persons;
    }
    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\">";
        html += "</div>";

        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");

        return sb.toString();
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16() {
        String html = "<div><input type=\"text\" placeholder=\"내용\"></div>";

        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17() {
        String html = """
                <div>
                    <input type="text" placeholder="내용">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18() {
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String content
    ) {
        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject, content);

        return html;
    }

    @GetMapping("/calc20")
    String showCalc20() {
        return "calc20";
    }
    @GetMapping("/calc21")
    //calc21.html에 v1 v2 타임리프로 정의됨
    //모델은 알아서 처리해줌
    String showCalc21(Model model) {
        model.addAttribute("v1","v1값");
        model.addAttribute("v2","v2값");
        return "calc21";
    }
    int num =0;
    @GetMapping("/calc22")
    @ResponseBody
    int showCalc22() {

        num++;

        // 모델에 카운트 값을 추가


        return num;
    }
}

@AllArgsConstructor
//모든 필드를 아규먼트로 받는 생성자
class Person{
    public String name;
    public int age;

}
@AllArgsConstructor
@Getter
//모든 필드를 아규먼트로 받는 생성자
class Person2{
    private String name;
    private int age;

}
