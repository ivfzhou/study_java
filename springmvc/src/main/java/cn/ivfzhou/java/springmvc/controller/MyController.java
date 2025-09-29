package cn.ivfzhou.java.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @CrossOrigin("http://ivfzhoudebian:8080")
    @RequestMapping("/get")
    public String get() {
        System.out.println("get");
        return "redirect:redirect";
    }

    @RequestMapping("/post")
    public String post() {
        System.out.println("post");
        return "forward:forward";
    }

    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect";
    }

    @RequestMapping("/forward")
    public String forward() {
        return "forward";
    }

    @ResponseBody
    @RequestMapping("/body")
    public String body(@RequestBody String body) {
        return "hello world" + body;
    }

}
