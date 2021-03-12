package com.homework.service;

import com.homework.exception.BadArgumentException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListResponder {

    List<String> femaleList = new NameListsGenerator().femaleList();
    List<String> maleList = new NameListsGenerator().maleList();
    List<List<String>> nameLists = Arrays.asList(femaleList, maleList);
    List<String> answer;

    public List<String> showNameLists(String id) {
        if (id.equals("maleList")) {
            answer = maleList;

        } else if (id.equals("femaleList")) {
            answer = femaleList;

        } else if (id.length()==1){
            if (id.charAt(0) >= 'a' && id.charAt(0) <='ż' ||
                    id.charAt(0) >= 'A' && id.charAt(0) <='Ż')

                answer = nameLists.stream().flatMap(Collection::stream)
                        .filter(name -> name.startsWith(id.toUpperCase()))
                        .sorted()
                        .collect(Collectors.toList());
            else {
                throw new BadArgumentException();
            }
        } else {

            answer = nameLists.stream().flatMap(Collection::stream)
                    .filter(name -> name.contains(id.toLowerCase().substring(0, 1).toUpperCase() + id.substring(1)))
                    .sorted()
                    .collect(Collectors.toList());
        }
        return answer;
}
}
