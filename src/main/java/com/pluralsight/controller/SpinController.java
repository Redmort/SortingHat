package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Plamen Admin on 9/14/2019.
 */

@Controller
public class SpinController {

    @RequestMapping(value = "/spin")
    public String spin(){
        return "hello";
    }
}
