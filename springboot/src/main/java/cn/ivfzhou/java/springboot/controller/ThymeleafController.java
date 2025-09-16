package cn.ivfzhou.java.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.ivfzhou.java.springboot.bean.Student;

@Controller
public class ThymeleafController {

    @RequestMapping("/render0")
    public ModelAndView render0() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("textual", "你好");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "李四"));
        mv.addObject("students", list);
        return mv;
    }

    @RequestMapping("/render1")
    public String render1(ModelMap map) {
        map.put("textual", "你好");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "李四"));
        map.put("students", list);
        return "index";
    }

    @RequestMapping("/render2")
    public String render3(ModelMap map) {
        map.put("textual", "你好");
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "张三"));
        list.add(new Student(2, "李四"));
        map.put("students", list);
        return "index";
    }

    @RequestMapping("/render3")
    public String render4(@ModelAttribute("textual") String textual, @RequestParam("students") List<Student> students) {
        System.out.println(textual);
        System.out.println(students);
        return "index";
    }

}
