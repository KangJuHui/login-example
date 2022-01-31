package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러는 이 어노테이션을 써줘야함.
public class HelloController {

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    public Hello helloString(@RequestParam("name") String name) {
        //return "hello " + name; //"hello spring" 문자가 크라이언트에 그대로 내려감.
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체를 넘김.
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
