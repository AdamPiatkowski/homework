package com.homework.controller;


import com.homework.service.GenderDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenderCheckController {

    private final GenderDetector genderDetector;

    @Autowired
    GenderCheckController(GenderDetector genderDetector) {
        this.genderDetector = genderDetector;
    }


    @PostMapping("/index")
    public void input(@RequestParam String checkName,@RequestParam String check, Model model) {
        checkGenderByName(checkName,check,model);
    }


    public void checkGenderByName(String checkName, String check, Model model) {
        String answer = check.equals("check") ? genderDetector.detectGenderByFirstName(checkName)
                :  genderDetector.detectGenderByAllNames(checkName);

        String answerOnWebsite = answerOnWebsite(answer);

        model.addAttribute("checkedGender", answerOnWebsite);
    }


    public String answerOnWebsite( String gender) {
         return gender.equals("INCONCLUSIVE") ? "INCONCLUSIVE" : "YOU ARE " + gender +"!";
    }

}
