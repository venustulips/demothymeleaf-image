package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content");
        mv.addObject("binaryData", new BinaryData());
        return mv;
    }

    @PostMapping("/")
    public ModelAndView post(@ModelAttribute("binaryData") BinaryData binaryData) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("content");
        final var path = Path.of(UUID.randomUUID().toString().concat(".jpg"));
        System.out.println("path = " + path);
        Files.write(path, binaryData.getImage());
        mv.addObject("binaryData", binaryData);
        return mv;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(byte[].class, new CustomByteArrayPropertyEditor());
    }
}

