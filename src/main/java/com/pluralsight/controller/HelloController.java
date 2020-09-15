package com.pluralsight.controller;

import com.pluralsight.logic.KidsTable;
import com.pluralsight.model.Kid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value ="/start")
    public String sayHello(Model model){

        if(MinutesController.count1 == -1) {
            KidsTable.generateKids();
        }
//        Kid kid = KidsTable.getKid();
//        model.addAttribute("firstName", kid.getFirstName());
//        model.addAttribute("family", kid.getFamily());

        return "start";
    }
}
