package com.homework.controller;

import com.homework.service.ListResponder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class NameListsController {



    @GetMapping(value = "nameLists/{id}", produces = "application/json")
    @ResponseBody
    public List<String> showNameLists (@PathVariable ("id") String id) {
        return new ListResponder().showNameLists(id);
    }
}
