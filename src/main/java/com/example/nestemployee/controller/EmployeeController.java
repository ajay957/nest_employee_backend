package com.example.nestemployee.controller;

import com.example.nestemployee.dao.EmployeeDao;
import com.example.nestemployee.model.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EmployeeController {

    private EmployeeDao edao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> AddEmployee(@RequestBody Employee e){
        edao.save(e);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
