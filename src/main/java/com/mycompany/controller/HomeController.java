package com.mycompany.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojo.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Quoc
 */
@Controller
public class HomeController {

    @Autowired
    private Cloudinary cloudinary;
    private LocalSessionFactoryBean sessionFactory;

    @RequestMapping("/")
    public String index(Model model) {
//        List<String> cates = new ArrayList<>();
//        cates.add("Mobile");
//        cates.add("Laptop");
//        cates.add("Desktop");
//        cates.add("Tablet");        
        Session session = sessionFactory.getObject().openSession();
        Query q = session.createQuery("From Category");
        model.addAttribute("name", "Nguyen Van A");
//        model.addAttribute("categories", cates);
//        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping("hello/{name}")
    public String test(Model model,
            @PathVariable(name = "name") String name) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/hello2")
    public String hello2(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        String fn = params.get("firstName");
        String ln = params.get("lastName");
        model.addAttribute("name", fn + " " + ln);
        return "index";
    }

    @GetMapping("/login")
    public String loginView(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginHandler(Model model,
            @ModelAttribute(value = "user") User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123")) {
            model.addAttribute("msg", "SUCCESSFULLY");
        } else {
            model.addAttribute("msg", "FAILED");
        }
        return "login";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute(value = "user") User user) throws IOException {
        Map res = this.cloudinary.uploader().upload(user.getAvatar().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
        System.out.println(res);
        return "redirect:/login?path=test";
    }
}
