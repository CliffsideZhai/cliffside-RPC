package com.cliffside.controller;

import com.cliffside.pojo.Person;
import com.cliffside.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cliffside
 * @date 2020-12-16 18:56
 */
@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/show")
    @ResponseBody
    public List<Person> show(){
        return personService.show();
    }
}
