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
    public List<String> showNameLists (Model model) {
        List<String> femaleList = showFemaleList();
        List<String> maleList = showMaleList();
        List<List<String>>nameLists = Arrays.asList(femaleList,maleList);

        model.addAttribute("src/main/resources/static/maleNames.txt", nameLists);

        return maleList;
    }


    public List<String> showFemaleList() {

        try(BufferedReader  br = new BufferedReader(
                new FileReader("src/main/resources/static/femaleNames.txt"))) {

                return names(br);
             }catch (IOException e) {
            System.out.println(e.getMessage());
            }
        return  new ArrayList<>();
    }


    public List<String> names (BufferedReader br) {
        return br.lines().parallel()
                         .collect(Collectors.toList());
    }


    public List<String> showMaleList() {


        try(BufferedReader  br = new BufferedReader(
                new FileReader("static/maleNames.txt"))) {
            List <String> maleList = br.lines().parallel()
                                 .collect(Collectors.toList());
            System.out.println(maleList.toString());
            return maleList;
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
