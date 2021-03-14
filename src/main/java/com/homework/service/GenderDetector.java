package com.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Service
public class GenderDetector {

    MaleDetector maleDetector;
    FemaleDetector femaleDetector;

    @Autowired
    public GenderDetector(MaleDetector maleDetector, FemaleDetector femaleDetector) {
        this.maleDetector = maleDetector;
        this.femaleDetector = femaleDetector;
    }


    public String detectGenderByFirstName(String name) {
        List<String> names = Arrays.asList(name.split(" "));
        String  firstName =names.get(0);
        String isMale = maleDetector.isMale(firstName);
        String isFemale = femaleDetector.isFemale(firstName);

        return isMale.equals("MALE") ? "MALE" :
                isFemale.equals("FEMALE") ?"FEMALE" :"INCONCLUSIVE";
    }


    public String detectGenderByAllNames(String name) {
        int numberOfManNames = 0;
        int numberOfFemaleNames = 0;
        List<String> names = Arrays.asList(name.split(" "));

        for (String singleName : names) {
            String gender = detectGenderByFirstName(singleName);

            if (gender.equals("MALE")) {
                numberOfManNames++;
            } else if (gender.equals("FEMALE")) {
                numberOfFemaleNames++;
            }
        }
        return numberOfManNames > numberOfFemaleNames ? "MALE" :
                numberOfManNames < numberOfFemaleNames ? "FEMALE" : "INCONCLUSIVE";
    }

    public void checkGenderByName(String checkName, String check, Model model) {
        String answer = check.equals("1") ? detectGenderByFirstName(checkName)
                :  detectGenderByAllNames(checkName);

        model.addAttribute("checkedGender", answer);
    }
}
