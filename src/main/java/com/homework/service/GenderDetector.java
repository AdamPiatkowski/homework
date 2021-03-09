package com.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class GenderDetector {

    MaleDetector maleDetector;
    FemaleDetector femaleDetector;


    @Autowired
    public GenderDetector(MaleDetector maleDetector, FemaleDetector femaleDetector){
        this.maleDetector = maleDetector;
        this.femaleDetector = femaleDetector;
    }

    public String detectGenderByFirstName(String name) throws IOException {

        String nameToCheck = Arrays.asList(name.trim().split(" ")).get(0);
        String isMale = maleDetector.isMale(nameToCheck);
        String isFemale = femaleDetector.isFemale(nameToCheck);

        if(isMale.equals("MALE")){
            return "MALE";
        }else if (isFemale.equals("FEMALE")){
            return "FEMALE";
        }else {
            return "INCONCLUSIVE";
        }
    }

    public String detectGenderByAllNames (String name) throws IOException{
        int numberOfManNames = 0;
        int numberOfFemaleNames = 0;
        List<String> names = Arrays.asList(name.split(" "));

        for (String singleName : names) {
            singleName.trim();
            String gender = detectGenderByFirstName(singleName);

            if (gender == "MALE") {
                numberOfManNames++;
            } else if (gender == "FEMALE") {
                numberOfFemaleNames++;
            }}

            if (numberOfManNames > numberOfFemaleNames) {
                return "MALE";
            } else if (numberOfManNames < numberOfFemaleNames) {
                return "FEMALE";
            }

            return "INCONCLUSIVE";
        }

}
