package com.homework.service;

import com.homework.exception.NamesDataNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NameListsGenerator {


    public List<String> maleList() {
        try (BufferedReader br = new BufferedReader(
                        new FileReader("src/main/resources/static/maleNames.txt"))) {

            List <String> maleList = br.lines().parallel()
                    .filter(x -> x.length() > 0)
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            return maleList;
        } catch (IOException e){
              throw new NamesDataNotFoundException();
        }
    }

    public List<String> femaleList() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/femaleNames.txt"))) {

            List <String> maleList = br.lines().parallel()
                    .filter(x -> x.length() > 0)
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            return maleList;
        } catch (IOException e){
            throw new NamesDataNotFoundException();
        }
    }

}
