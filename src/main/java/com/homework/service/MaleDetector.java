package com.homework.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class MaleDetector {

    public String isMale(String name) throws IOException {

        BufferedReader brMale = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\homework\\src\\main\\resources\\maleNames"));
        String maleName = brMale.readLine();
        while (maleName != null) {
            boolean isMaleName = name.trim().equalsIgnoreCase(maleName.trim());

            if (isMaleName == true) {
                return "MALE";
            }
            maleName = brMale.readLine();
        }
        return "INCONCLUSIVE";
    }
}

