package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content1");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/")
    public ModelAndView createhome(@ModelAttribute("user") User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content1");

        user.setImageStr(new String(user.getImage(), StandardCharsets.UTF_8));
        mv.addObject("user", user);
        return mv;
    }
}

class User {

    private byte[] image;
    private String imageContentType;

    // must be a transient variable in JPA entity
    private String imageStr;


    public byte[] getImage() {
        return image;
    }

    public User setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public User setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public String getImageStr() {
        return imageStr;
    }

    public User setImageStr(String imageStr) {
        this.imageStr = imageStr;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "image=" + Arrays.toString(image) +
                ", imageContentType='" + imageContentType + '\'' +
                ", imageStr='" + imageStr + '\'' +
                '}';
    }
}