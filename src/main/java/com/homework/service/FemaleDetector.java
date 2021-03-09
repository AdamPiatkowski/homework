package com.homework.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FemaleDetector {

    public String isFemale(String name) throws IOException {

        BufferedReader brFemale = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\homework\\src\\main\\resources\\femaleNames"));
        String femaleName = brFemale.readLine();
        while (femaleName != null) {
            boolean isFemaleName = name.trim().equalsIgnoreCase(femaleName.trim());

            if (isFemaleName == true) {
                return "FEMALE";
            }
            femaleName = brFemale.readLine();
        }
        return "INCONCLUSIVE";
    }
}
