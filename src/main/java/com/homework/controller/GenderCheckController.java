package com.homework.controller;


import com.homework.service.GenderDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class GenderCheckController {

    @Autowired
    private final GenderDetector genderDetector;

    @Autowired
    GenderCheckController (GenderDetector genderDetector){
        this.genderDetector = genderDetector;
    }
    @PostMapping("/index")
    public String checkGenderByName (@RequestParam String checkName, Model model) throws IOException {
        System.out.println(checkName);

        String [] nameList = checkName.split(" ");
        System.out.println(nameList.length);
        String answer = "";

        if (nameList.length == 1) {
            answer = genderDetector.detectGenderByFirstName(checkName);
        } else if (nameList.length>1){
            answer = genderDetector.detectGenderByAllNames(checkName);
        }
        model.addAttribute ("checkedGender", answer);

        return "checkedGender";
    }

//    @PostMapping ("/index")
//    public String checkGenderByAllNames (@RequestParam String checkNames, Model model) throws IOException {
//        System.out.println(checkNames);
//
//        String [] nameList = checkNames.split(" ");
//        System.out.println(nameList.length);
//        String answer = "";

//        if (nameList.length == 1) {
//            answer = genderDetector.detectGenderByFirstName(checkNames);
//        } else if (nameList.length>1){
//            answer = genderDetector.detectGenderByAllNames(checkNames);
//        }
//        model.addAttribute("checkedGender", answer);
//        return "checkedGender";
//    }

}
