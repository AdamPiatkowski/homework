package com.homework.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FemaleDetector {

    long isFemaleName = 0;
    public String isFemale(String name) {

        try(BufferedReader brMale = new BufferedReader(
                new FileReader("src/main/resources/static/femaleNames.txt"))) {

            isFemaleName = brMale.lines()
                    .parallel()
                    .map(x -> x.trim())
                    .filter(x-> x.equalsIgnoreCase(name))
                    .count();

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  (isFemaleName > 0) ? "FEMALE" : "INCONCLUSIVE";
    }
}
