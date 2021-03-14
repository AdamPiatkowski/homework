package com.homework.controller;

import com.homework.service.GenderDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenderCheckController {


    GenderDetector genderDetector;

    @Autowired
    GenderCheckController(GenderDetector genderDetector) {
        this.genderDetector = genderDetector;
    }

    @PostMapping("/index")
    public void input(@RequestParam String checkName,@RequestParam String check, Model model) {
        genderDetector.checkGenderByName(checkName,check,model);
    }


}
