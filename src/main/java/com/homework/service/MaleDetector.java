package com.homework.service;

import com.homework.exception.NamesDataNotFoundException;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class MaleDetector {

    long isMaleName = 0;
    public String isMale(String name) {

        try(BufferedReader brMale = new BufferedReader(
                    new FileReader("src/main/resources/static/maleNames.txt"))) {

            isMaleName = brMale.lines()
                    .parallel()
                    .map(x -> x.trim().toLowerCase())
                    .filter(x-> x.equalsIgnoreCase(name))
                    .count();

        }catch (IOException e) {
            throw new NamesDataNotFoundException();
        }
            return  (isMaleName > 0) ? "MALE" :"INCONCLUSIVE";
    }
}

