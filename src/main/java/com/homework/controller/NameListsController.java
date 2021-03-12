package com.homework.controller;

import com.homework.exception.BadArgumentException;
import com.homework.exception.NamesDataNotFoundException;
import com.homework.service.ListResponder;
import com.homework.service.NameListsGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class NameListsController {



    @GetMapping(value = "nameLists/{id}", produces = "application/json")
    @ResponseBody
    public List<String> showNameLists (@PathVariable ("id") String id) {
        return new ListResponder().showNameLists(id);
    }
}
