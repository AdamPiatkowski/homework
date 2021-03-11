package com.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NameLists {


    @GetMapping("/nameLists")
    public List<List<String>> showNameLists (Model model) {

        List<String> femaleList = showFemaleList();
        List<String> maleList = showMaleList();
        List<List<String>>nameLists = Arrays.asList(femaleList,maleList);
        model.addAttribute("nameLists", nameLists);

        return nameLists;
    }


    public List<String> showFemaleList() {

        try(BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/femaleNames.txt"))) {

            List<String> names = br.lines().parallel()
                    .filter(x -> x.length() > 0)
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                    .distinct()
                    .collect(Collectors.toList());

                return names;
             }catch (IOException e) {
            System.out.println(e.getMessage());
            }
        return  new ArrayList<>();
    }


    public List<String> showMaleList() {


        try(BufferedReader br = new BufferedReader(
                new FileReader("src/main/resources/static/maleNames.txt"))) {
            List <String> maleList = br.lines().parallel()
                    .filter(x -> x.length() > 0)
                    .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                    .distinct()
                    .collect(Collectors.toList());


            return maleList;
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
