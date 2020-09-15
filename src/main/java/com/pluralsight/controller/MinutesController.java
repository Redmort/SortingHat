package com.pluralsight.controller;

import com.pluralsight.Constants;
import com.pluralsight.io.Writer;
import com.pluralsight.logic.KidsTable;
import com.pluralsight.model.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Random;

@RestController
public class MinutesController {

    public static int count1 = -1;

    @RequestMapping(value = "/addMinutes")
    public String addMinutes(Model model) throws InterruptedException, SQLException, FileNotFoundException, UnsupportedEncodingException {

        String response = NetClient.getRespons("http://localhost:8070/isReady.html");

    while (!"true".equals(response)){
        Thread.sleep(100);
        response = NetClient.getRespons("http://localhost:8070/isReady.html");
    }

    String choose = "1";
    if(count1 > 0) {

        if(count1 == Constants.CHILD_ZERO + 1){
            Diplomati.addGrade(1);
            Intelekti.addGrade(1);
            Harmoni.addGrade(1);
            Ideali.addGrade(1);
        }

        if(count1 == Constants.CHILD_ZERO + Constants.CHILD_FIRST + 1){
            Diplomati.addGrade(2);
            Intelekti.addGrade(2);
            Harmoni.addGrade(2);
            Ideali.addGrade(2);
        }

        if(count1 == Constants.CHILD_ZERO + Constants.CHILD_FIRST + Constants.CHILD_SECOND + 1){
            Diplomati.addGrade(3);
            Intelekti.addGrade(3);
            Harmoni.addGrade(3);
            Ideali.addGrade(3);
        }

        if(count1 == Constants.CHILD_ZERO + Constants.CHILD_FIRST + Constants.CHILD_SECOND + Constants.CHILD_THIRD + 1){
            Diplomati.addGrade(4);
            Intelekti.addGrade(4);
            Harmoni.addGrade(4);
            Ideali.addGrade(4);
        }

        if(count1 == Constants.CHILD_ZERO + Constants.CHILD_FIRST + Constants.CHILD_SECOND + Constants.CHILD_THIRD +
                Constants.CHILD_FOURTH + 1){
            Diplomati.addGrade(5);
            Intelekti.addGrade(5);
            Harmoni.addGrade(5);
            Ideali.addGrade(5);
        }

        if(count1 == Constants.CHILD_ZERO + Constants.CHILD_FIRST + Constants.CHILD_SECOND + Constants.CHILD_THIRD +
                Constants.CHILD_FOURTH + Constants.CHILD_FIFTH + 1){
            Diplomati.addGrade(6);
            Intelekti.addGrade(6);
            Harmoni.addGrade(6);
            Ideali.addGrade(6);
        }

        if (KidsTable.count < KidsTable.kidsCount()) {
            Kid kid = KidsTable.getKid();
            choose = ChooseDom.makeChoose(kid);
            kid.setHouse(choose);
            Writer.write(kid);
        }else {
            Random r = new Random();
            choose = String.valueOf(r.nextInt(4) + 1);
        }
    }
        count1++;
        NetClient.getRespons("http://localhost:8070/setHouseNum.html?id=" + choose);

        return choose;
    }


    @RequestMapping(value = "/reset")
    public String reset(){

        String response =  NetClient.getRespons("http://localhost:8070/reload.html");
        return "response";
    }


}
