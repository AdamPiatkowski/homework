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
    public String checkGenderByName (@RequestParam String checkName,@RequestParam String check, Model model) throws IOException {

        String answer = check.equals("1") ? genderDetector.detectGenderByFirstName(checkName)
                :  genderDetector.detectGenderByAllNames(checkName);

        model.addAttribute ("checkedGender", answer);

        return "checkedGender";
    }
}
